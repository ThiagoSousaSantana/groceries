package com.groceries.models.product

import com.groceries.models.store.StoreMainData
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.UUID

data class ProductWithBestPriceStore(
    val id: UUID,
    val sku: String,
    val name: String,
    val bestPrice: BigDecimal,
    val updatedAt: Timestamp,
    val bestPriceStore: StoreMainData
)
