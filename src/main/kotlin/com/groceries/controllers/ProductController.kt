package com.groceries.controllers

import com.groceries.models.Product
import com.groceries.services.ProductService
import com.groceries.vo.StoreSmallResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(val storeService: ProductService) {

    @GetMapping
    fun listProducts(): List<ProductResponse> {
        val products = storeService.listProducts()

        return products.map {
            ProductResponse(
                id = it.id,
                sku = it.sku,
                name = it.name,
                bestPrice = it.bestPrice,
                updatedAt = it.updatedAt,
                bestPriceStore = StoreSmallResponse(
                    id = it.bestPriceStore.id,
                    name = it.bestPriceStore.name,
                    cnpj = it.bestPriceStore.cnpj,
                    address = it.bestPriceStore.address
                )
            )
        }
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: String): Product {
        return storeService.getProduct(id)
    }
}