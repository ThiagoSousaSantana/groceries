package com.groceries.models

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val sku: String,
    val name: String,
    val bestPrice: BigDecimal,

    @OneToMany(mappedBy = "product")
    val prices: List<Price> = emptyList(),
    @ManyToOne
    val bestPriceStore: Store? = null,
    @ManyToOne
    val group: ProductGroup? = null,
    @ManyToOne
    val brand: Brand? = null,
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val createdAt: LocalDateTime = LocalDateTime.now()
)
