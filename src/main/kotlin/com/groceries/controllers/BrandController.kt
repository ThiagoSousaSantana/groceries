package com.groceries.controllers

import com.groceries.models.Brand
import com.groceries.services.BrandService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Product Brands")
@RestController
@RequestMapping("/v1/product/brands")
class BrandController(val brandService: BrandService) {

    @Operation(summary = "Get all brands")
    @GetMapping
    fun findAll(): List<Brand> {
        return brandService.findAll()
    }

    @Operation(summary = "Get brand by id")
    @PostMapping
    fun save(@RequestBody brand: Brand): ResponseEntity<Brand> {
        val response = brandService.save(brand)
        return ResponseEntity(response, HttpStatus.CREATED)
    }

}