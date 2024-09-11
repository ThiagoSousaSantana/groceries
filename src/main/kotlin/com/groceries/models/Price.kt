package com.groceries.models

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Entity
data class Price(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val price: BigDecimal,
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val product: Product,

    @ManyToOne(fetch = FetchType.LAZY)
    val store: Store
)
