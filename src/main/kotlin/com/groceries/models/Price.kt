package com.groceries.models

import jakarta.persistence.*
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.UUID

@Entity
data class Price(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val price: BigDecimal,
    val createdAt: Timestamp = Timestamp(System.currentTimeMillis()),

    @ManyToOne
    val product: Product,

    @ManyToOne
    val store: Store
)
