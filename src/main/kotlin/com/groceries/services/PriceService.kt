package com.groceries.services

import com.groceries.models.Invoice
import com.groceries.models.Price
import com.groceries.models.Product
import com.groceries.repositories.PriceRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class PriceService(val priceRepository: PriceRepository) {

    @Transactional
    fun createPrice(product: Product, invoice: Invoice): Price {
        return priceRepository.save(
            Price(
                product = product,
                store = invoice.store,
                price = product.bestPrice
            )
        )
    }

}
