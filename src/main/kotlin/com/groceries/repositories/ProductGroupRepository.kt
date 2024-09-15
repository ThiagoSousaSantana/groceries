package com.groceries.repositories

import com.groceries.models.ProductGroup
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductGroupRepository : JpaRepository<ProductGroup, UUID>