package com.groceries.repositories

import com.groceries.models.Price
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PriceRepository : JpaRepository<Price, UUID>