package com.groceries.vo

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

data class ProductResponse(
    val id: UUID,
    val sku: String,
    val name: String,
    val bestPrice: BigDecimal,
    val updatedAt: LocalDateTime,
    val bestPriceStore: StoreSmallResponse
)
