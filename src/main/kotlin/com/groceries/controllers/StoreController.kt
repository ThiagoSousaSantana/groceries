package com.groceries.controllers

import com.groceries.models.Store
import com.groceries.services.StoreService
import com.groceries.vo.ErrorResponse
import com.groceries.vo.StoreRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@Tag(name = "Stores")
@RestController
@RequestMapping("/v1/stores")
class StoreController(val storeService: StoreService) {

    @Operation(summary = "Get all stores")
    @GetMapping
    fun getStores(): List<Store> {
        return storeService.getStores()
    }

    @Operation(summary = "Get store by id")
    @GetMapping("/{id}")
    fun getStore(@PathVariable id: String): Store {
        return storeService.getStore(id)
    }

    @Operation(summary = "Create store")
    @PostMapping
    fun createStore(@RequestBody store: StoreRequest): ResponseEntity<Store> {
        val response = storeService.createStore(Store(cnpj = store.cnpj, name = store.name, address = store.address))
        return ResponseEntity.created(URI.create("/stores/${response.id}")).body(response)
    }

    @Operation(summary = "Update store")
    @PutMapping("/{id}")
    fun updateStore(@PathVariable id: String, @RequestBody store: StoreRequest): Store {
        return storeService.updateStore(id, Store(cnpj = store.cnpj, name = store.name, address = store.address))
    }

    @Operation(summary = "Delete store")
    @ApiResponses( value = [
        ApiResponse(responseCode = "204", description = "Store deleted"),
        ApiResponse(responseCode = "404", description = "Store not found", content = [
            (Content(mediaType = "application/json", array = (
                    ArraySchema(schema = Schema(implementation = ErrorResponse::class)))))
        ])
    ])
    @DeleteMapping("/{id}")
    fun deleteStore(@PathVariable id: String) {
        storeService.deleteStore(id)
    }
}