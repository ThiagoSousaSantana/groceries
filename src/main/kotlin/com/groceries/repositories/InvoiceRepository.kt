package com.groceries.repositories

import com.groceries.models.Invoice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface InvoiceRepository : JpaRepository<Invoice, UUID>