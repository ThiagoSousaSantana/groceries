package com.groceries.controllers

import com.groceries.models.ProductCategory
import com.groceries.services.ProductCategoryService
import com.groceries.vo.ProductCategoryRequest
import com.groceries.vo.ProductCategoryResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Product Categories")
@RestController
@RequestMapping("/v1/product/categories")
class ProductCategoryController(val productCategoryService: ProductCategoryService) {

    @Operation(summary = "Get all product categories")
    @GetMapping
    fun findAll(): List<ProductCategoryResponse> {
        return productCategoryService.findAll().map { mapToResponse(it) }
    }

    @Operation(summary = "Get product category by id")
    @PostMapping
    fun save(@RequestBody request: ProductCategoryRequest): ResponseEntity<ProductCategoryResponse> {
        val productGroup = productCategoryService.save(request)

        return ResponseEntity(mapToResponse(productGroup), HttpStatus.CREATED)
    }

    private fun mapToResponse(productCategory: ProductCategory): ProductCategoryResponse {
        val response = ProductCategoryResponse(
            id = productCategory.id!!,
            name = productCategory.name,
            parent = productCategory.parent?.let { mapToResponse(it) },
            updatedAt = productCategory.updatedAt,
            createdAt = productCategory.createdAt
        )
        return response
    }
}