package com.groceries.models

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Entity
data class Invoice(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val total: BigDecimal,
    @ManyToOne
    val store: Store,
    @OneToMany(mappedBy = "invoice")
    val products: List<InvoiceProducts> = emptyList(),
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
