package com.groceries.models.product

import com.groceries.models.store.StoreMainData
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class ProductWithBestPriceStore(
    val id: UUID,
    val sku: String,
    val name: String,
    val bestPrice: BigDecimal,
    val updatedAt: LocalDateTime,
    val bestPriceStore: StoreMainData
)
