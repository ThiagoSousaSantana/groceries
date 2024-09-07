package com.groceries.vo

import java.math.BigDecimal

data class InvoiceProductsRequest(
    val sku: String,
    val name: String,
    val quantity: BigDecimal,
    val price: BigDecimal
)
