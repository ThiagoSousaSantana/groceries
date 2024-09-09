package com.groceries.controllers

import com.groceries.models.Invoice
import com.groceries.services.InvoiceService
import com.groceries.vo.InvoiceProductResponse
import com.groceries.vo.InvoiceRequest
import com.groceries.vo.InvoiceResponse
import com.groceries.vo.StoreSmallResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoices")
class InvoiceController(val invoiceService: InvoiceService) {

    @GetMapping
    fun getInvoices(): List<InvoiceResponse> {
        return invoiceService.getInvoices().map { mapToResponse(it) }
    }

    @GetMapping("/{id}")
    fun getInvoice(@PathVariable id: String): InvoiceResponse {
        val invoice = invoiceService.getInvoice(id)

        return mapToResponse(invoice)
    }

    @PostMapping
    fun createInvoice(@RequestBody invoiceRequest: InvoiceRequest): InvoiceResponse {
        val invoice = invoiceService.createInvoice(invoiceRequest)

        return mapToResponse(invoice)
    }

    private fun mapToResponse(invoice: Invoice): InvoiceResponse {
        return InvoiceResponse(
            id = invoice.id.toString(),
            total = invoice.total,
            store = StoreSmallResponse(
                id = invoice.store.id,
                name = invoice.store.name,
                cnpj = invoice.store.cnpj,
                address = invoice.store.address
            ),
            products = invoice.products.map {
                InvoiceProductResponse(
                    id = it.id.toString(),
                    name = it.product.name,
                    price = it.price,
                    sku = it.product.sku,
                    quantity = it.quantity
                )
            }
        )
    }

//    @PutMapping("/{id}")
//    fun updateInvoice(@PathVariable id: String, @RequestBody invoice: InvoiceRequest): Invoice {
//        return invoiceService.updateInvoice(id, Invoice(name = invoice.name, address = invoice.address))
//    }
//
//    @DeleteMapping("/{id}")
//    fun deleteInvoice(@PathVariable id: String) {
//        invoiceService.deleteInvoice(id)
//    }
}