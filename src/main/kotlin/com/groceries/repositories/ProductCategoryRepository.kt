package com.groceries.repositories

import com.groceries.models.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProductCategoryRepository : JpaRepository<ProductCategory, UUID>