package com.groceries.controllers

import com.groceries.models.Store
import com.groceries.services.StoreService
import com.groceries.vo.StoreRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/stores")
class StoreController(val storeService: StoreService) {

    @GetMapping
    fun getStores(): List<Store> {
        return storeService.getStores()
    }

    @GetMapping("/{id}")
    fun getStore(@PathVariable id: String): Store {
        return storeService.getStore(id)
    }

    @PostMapping
    fun createStore(@RequestBody store: StoreRequest): Store {
        return storeService.createStore(Store(cnpj = store.cnpj, name = store.name, address = store.address))
    }

    @PutMapping("/{id}")
    fun updateStore(@PathVariable id: String, @RequestBody store: StoreRequest): Store {
        return storeService.updateStore(id, Store(cnpj = store.cnpj, name = store.name, address = store.address))
    }

    @DeleteMapping("/{id}")
    fun deleteStore(@PathVariable id: String) {
        storeService.deleteStore(id)
    }
}