package com.groceries.repositories

import com.groceries.models.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface BrandRepository : JpaRepository<Brand, UUID>