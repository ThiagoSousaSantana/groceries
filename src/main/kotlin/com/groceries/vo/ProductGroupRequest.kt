package com.groceries.vo

import java.util.UUID

data class ProductGroupRequest(
    val name: String,
    val categoryId: UUID?
)
