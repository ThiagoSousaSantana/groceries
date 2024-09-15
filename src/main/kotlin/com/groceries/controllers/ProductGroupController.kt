package com.groceries.controllers

import com.groceries.models.ProductGroup
import com.groceries.services.ProductGroupService
import com.groceries.vo.ProductGroupRequest
import com.groceries.vo.ProductGroupResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Product Groups")
@RestController
@RequestMapping("/v1/product/groups")
class ProductGroupController(val productGroupService: ProductGroupService) {

    @Operation(summary = "Get all product groups")
    @GetMapping
    fun findAll(): List<ProductGroupResponse> {
        return productGroupService.findAll().map { mapToResponse(it) }
    }

    @Operation(summary = "Get product group by id")
    @PostMapping
    fun save(@RequestBody request: ProductGroupRequest): ResponseEntity<ProductGroupResponse> {
        val productGroup = productGroupService.save(request)

        return ResponseEntity(mapToResponse(productGroup), HttpStatus.CREATED)
    }

    private fun mapToResponse(productGroup: ProductGroup): ProductGroupResponse {
        val response = ProductGroupResponse(
            id = productGroup.id!!,
            name = productGroup.name,
            category = productGroup.category?.name,
            updatedAt = productGroup.updatedAt,
            createdAt = productGroup.createdAt
        )
        return response
    }
}