package com.groceries.models

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
data class Store(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val cnpj: String,
    val name: String,
    val address: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    @OneToMany(mappedBy = "store")
    val prices: List<Price> = emptyList()
)
