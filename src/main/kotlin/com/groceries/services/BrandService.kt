package com.groceries.services

import com.groceries.exeptions.EntityNotFoundException
import com.groceries.models.Brand
import com.groceries.repositories.BrandRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BrandService(val brandRepository: BrandRepository) {

    fun findAll(): List<Brand> {
        return brandRepository.findAll()
    }

    fun findById(id: UUID): Brand {
        return brandRepository.findById(id).orElseThrow { EntityNotFoundException("Brand") }
    }

    fun save(brand: Brand): Brand {
        return brandRepository.save(brand)
    }
}