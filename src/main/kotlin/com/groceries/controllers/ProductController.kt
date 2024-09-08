package com.groceries.controllers

import com.groceries.models.Product
import com.groceries.models.Store
import com.groceries.services.ProductService
import com.groceries.services.StoreService
import com.groceries.vo.StoreRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(val storeService: ProductService) {

    @GetMapping
    fun getStores(): List<Product> {
        return storeService.getProducts()
    }

    @GetMapping("/{id}")
    fun getStore(@PathVariable id: String): Product {
        return storeService.getProduct(id)
    }
}