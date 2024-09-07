package com.groceries.vo

import java.math.BigDecimal

data class InvoiceResponse(
    val id: String,
    val total: BigDecimal,
    val store: StoreSmallResponse,
    val products: List<InvoiceProductResponse>
)
