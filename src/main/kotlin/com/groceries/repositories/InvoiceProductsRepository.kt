package com.groceries.repositories

import com.groceries.models.InvoiceProducts
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface InvoiceProductsRepository : JpaRepository<InvoiceProducts, UUID>