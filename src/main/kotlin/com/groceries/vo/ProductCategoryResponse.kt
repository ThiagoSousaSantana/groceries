package com.groceries.vo

import java.time.LocalDateTime
import java.util.UUID

data class ProductCategoryResponse(
    val id: UUID,
    val name: String,
    val parent: ProductCategoryResponse? = null,
    val updatedAt: LocalDateTime,
    val createdAt: LocalDateTime
)
