package com.groceries.services

import com.groceries.exeptions.EntityNotFoundException
import com.groceries.models.ProductCategory
import com.groceries.repositories.ProductCategoryRepository
import com.groceries.vo.ProductCategoryRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductCategoryService(val productCategoryRepository: ProductCategoryRepository) {

    fun findAll() = productCategoryRepository.findAll()

    fun findById(id: UUID): ProductCategory {
        return productCategoryRepository.findById(id).orElseThrow { EntityNotFoundException("Product Category") }
    }

    fun save(request: ProductCategoryRequest): ProductCategory {
        val category = request.parentId?.let { findById(it) }

        return productCategoryRepository.save(
            ProductCategory(
                name = request.name,
                parent = category
            )
        )
    }

}
