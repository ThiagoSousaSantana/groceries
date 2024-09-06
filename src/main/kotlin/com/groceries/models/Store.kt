package com.groceries.models

import jakarta.persistence.*

@Entity
data class Store(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null,
    val name: String,
    val address: String,
    val createdAt: Long,
    val updatedAt: Long,
    @OneToMany(mappedBy = "store")
    val prices: List<Price>
)
