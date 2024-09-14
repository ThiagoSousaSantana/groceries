package com.groceries.services

import com.groceries.exeptions.EntityNotFoundException
import com.groceries.models.Invoice
import com.groceries.models.InvoiceProducts
import com.groceries.repositories.InvoiceProductsRepository
import com.groceries.repositories.InvoiceRepository
import com.groceries.vo.InvoiceRequest
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class InvoiceService(
    val invoiceRepository: InvoiceRepository,
    val invoiceProductsRepository: InvoiceProductsRepository,
    val storeService: StoreService,
    val productService: ProductService
) {

    fun getInvoices(): List<Invoice> {
        return invoiceRepository.findAll()
    }

    fun getInvoice(id: String): Invoice {
        return invoiceRepository.findById(UUID.fromString(id))
            .orElseThrow { throw EntityNotFoundException("Invoice") }
    }

    @Transactional
    fun createInvoice(invoiceRequest: InvoiceRequest): Invoice {
        val store = storeService.getStoreByCNPJ(invoiceRequest.storeCNPJ)

        val invoice = invoiceRepository.save(
            Invoice(
                total = invoiceRequest.total,
                store = store
            )
        )

        val invoiceProductsList = invoiceRequest.products.map { productRequest ->
            val product = productService.processProduct(productRequest, invoice)
            invoiceProductsRepository.save(
                InvoiceProducts(
                    invoice = invoice,
                    product = product,
                    price = productRequest.price,
                    quantity = productRequest.quantity
                )
            )
        }

        return invoice.copy(products = invoiceProductsList)
    }

}
