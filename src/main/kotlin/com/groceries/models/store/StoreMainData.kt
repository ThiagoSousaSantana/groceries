package com.groceries.models.store

import java.util.UUID

data class StoreMainData(
    val id: UUID,
    val name: String,
    val cnpj: String,
    val address: String
)
