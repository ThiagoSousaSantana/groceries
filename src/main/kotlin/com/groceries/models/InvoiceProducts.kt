package com.groceries.models

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

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
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
