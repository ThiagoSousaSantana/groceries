package com.groceries.repositories

import com.groceries.models.Invoice
import com.groceries.models.Store
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface InvoiceRepository : JpaRepository<Invoice, UUID>