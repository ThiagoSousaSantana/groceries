package com.groceries.vo

import java.util.UUID

data class ProductCategoryRequest(
    val name: String,
    val parentId: UUID?
)
