package com.groceries.models

import jakarta.persistence.*
import java.sql.Timestamp
import java.util.UUID

@Entity
data class Store(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    val name: String,
    val address: String,
    val createdAt: Timestamp = Timestamp(System.currentTimeMillis()),
    val updatedAt: Timestamp = Timestamp(System.currentTimeMillis()),
    @OneToMany(mappedBy = "store")
    val prices: List<Price> = emptyList()
)
