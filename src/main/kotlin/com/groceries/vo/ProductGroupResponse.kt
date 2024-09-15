package com.groceries.vo

import java.time.LocalDateTime
import java.util.*

data class ProductGroupResponse(
    val id: UUID,
    val name: String,
    val category: String? = null,
    val updatedAt: LocalDateTime,
    val createdAt: LocalDateTime
)
