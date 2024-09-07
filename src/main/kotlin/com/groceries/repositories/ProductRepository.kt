package com.groceries.repositories

import com.groceries.models.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface ProductRepository : JpaRepository<Product, UUID> {
    fun findBySku(sku: String): Optional<Product>
}