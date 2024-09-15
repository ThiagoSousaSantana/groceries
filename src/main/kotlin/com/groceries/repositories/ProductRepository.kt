package com.groceries.repositories

import com.groceries.models.Product
import com.groceries.models.product.ProductWithBestPriceStore
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface ProductRepository : JpaRepository<Product, UUID> {
    fun findBySku(sku: String): Optional<Product>

    @Query(
        "SELECT " +
                "new com.groceries.models.product.ProductWithBestPriceStore(" +
                "p.id, p.sku, p.name, p.bestPrice, p.updatedAt, " +
                "new com.groceries.models.store.StoreMainData(" +
                "s.id, s.name, s.cnpj, s.address)) " +
                "FROM Product p " +
                "INNER JOIN Store s ON p.bestPriceStore.id = s.id"
    )
    fun findAllProducts(): List<ProductWithBestPriceStore>
}