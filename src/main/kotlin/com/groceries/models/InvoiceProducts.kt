package com.groceries.models

import jakarta.persistence.*
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.UUID

@Entity
data class InvoiceProducts(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val quantity: BigDecimal,
    val price: BigDecimal,
    @ManyToOne
    val product: Product,
    @ManyToOne
    val invoice: Invoice,
    val createdAt: Timestamp = Timestamp(System.currentTimeMillis()),
    val updatedAt: Timestamp = Timestamp(System.currentTimeMillis())
)
