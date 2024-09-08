package com.groceries.vo

import java.math.BigDecimal

data class InvoiceRequest (
    val total: BigDecimal,
    val storeCNPJ: String,
    val products: List<InvoiceProductsRequest>
)
