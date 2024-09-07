package com.groceries.vo

import java.math.BigDecimal

data class InvoiceProductResponse(
    val id: String,
    val name: String,
    val sku: String,
    val price: BigDecimal,
    val quantity: BigDecimal
)
