package com.groceries.services

import com.groceries.exeptions.EntityNotFoundException
import com.groceries.models.ProductGroup
import com.groceries.repositories.ProductGroupRepository
import com.groceries.vo.ProductGroupRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductGroupService(
    val productGroupRepository: ProductGroupRepository,
    val productCategoryService: ProductCategoryService,
) {

    fun findAll(): List<ProductGroup> = productGroupRepository.findAll()

    fun findById(id: UUID): ProductGroup {
        return productGroupRepository.findById(id).orElseThrow { EntityNotFoundException("Product Group") }
    }

    fun save(request: ProductGroupRequest): ProductGroup {
        val category = request.categoryId?.let { productCategoryService.findById(it) }

        return productGroupRepository.save(
            ProductGroup(
                name = request.name,
                category = category
            )
        )
    }
}
