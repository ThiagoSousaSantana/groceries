package com.groceries.vo

import java.util.UUID

data class StoreSmallResponse(
    val id: UUID?,
    val name: String,
    val cnpj: String,
    val address: String
)
