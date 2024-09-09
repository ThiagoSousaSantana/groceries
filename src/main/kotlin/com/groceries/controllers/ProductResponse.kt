package com.groceries.controllers

import com.groceries.vo.StoreSmallResponse
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.UUID

data class ProductResponse(
    val id: UUID,
    val sku: String,
    val name: String,
    val bestPrice: BigDecimal,
    val updatedAt: Timestamp,
    val bestPriceStore: StoreSmallResponse
)
