package com.groceries.services

import com.groceries.models.Store
import com.groceries.repositories.StoreRepository
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.util.*

@Service
class StoreService(val storeRepository: StoreRepository) {

    fun getStores(): List<Store> {
        return storeRepository.findAll()
    }

    fun getStore(id: String): Store {
        return storeRepository.findById(UUID.fromString(id)).orElseThrow { throw RuntimeException("Store not found") }
    }

    fun createStore(store: Store): Store {
        return storeRepository.save(store)
    }

    fun updateStore(id: String, store: Store): Store {
        val persistedStore = getStore(id)

        return storeRepository.save(persistedStore.copy(
            name = store.name,
            address = store.address,
            updatedAt = Timestamp(System.currentTimeMillis()))
        )
    }

    fun deleteStore(id: String) {
        storeRepository.existsById(UUID.fromString(id)).let {
            if (!it) throw RuntimeException("Store not found")
        }

        storeRepository.deleteById(UUID.fromString(id))
    }
}
