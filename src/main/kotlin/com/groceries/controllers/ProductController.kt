package com.groceries.controllers

import com.groceries.models.Product
import com.groceries.services.ProductService
import com.groceries.vo.ProductResponse
import com.groceries.vo.StoreSmallResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "Products")
@RestController
@RequestMapping("/v1/products")
class ProductController(val storeService: ProductService) {

    @Operation(summary = "List all products")
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

    @Operation(summary = "Get product by id")
    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: String): Product {
        return storeService.getProduct(id)
    }
}