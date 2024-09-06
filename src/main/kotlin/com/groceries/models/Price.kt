package com.groceries.models

import jakarta.persistence.*

@Entity
data class Price(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,
    val price: Double,
    val createdAt: Long,

    @ManyToOne
    val product: Product,

    @ManyToOne
    val store: Store
)
