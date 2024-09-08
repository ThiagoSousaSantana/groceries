package com.groceries.repositories

import com.groceries.models.Store
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface StoreRepository : JpaRepository<Store, UUID> {
    fun getStoreByCnpj(cnpj: String): Optional<Store>
}