package com.groceries.controllers

import com.groceries.models.Invoice
import com.groceries.services.InvoiceService
import com.groceries.vo.InvoiceProductResponse
import com.groceries.vo.InvoiceRequest
import com.groceries.vo.InvoiceResponse
import com.groceries.vo.StoreSmallResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@Tag(name = "Invoices")
@RestController
@RequestMapping("/v1/invoices")
class InvoiceController(val invoiceService: InvoiceService) {

    @Operation(summary = "Get all invoices")
    @GetMapping
    fun getInvoices(): List<InvoiceResponse> {
        return invoiceService.getInvoices().map { mapToResponse(it) }
    }

    @Operation(summary = "Get invoice by id")
    @GetMapping("/{id}")
    fun getInvoice(@PathVariable id: String): InvoiceResponse {
        val invoice = invoiceService.getInvoice(id)

        return mapToResponse(invoice)
    }

    @Operation(summary = "Create invoice")
    @PostMapping
    fun createInvoice(@RequestBody invoiceRequest: InvoiceRequest): ResponseEntity<InvoiceResponse> {
        val invoice = invoiceService.createInvoice(invoiceRequest)

        val response = mapToResponse(invoice)
        return ResponseEntity.created(URI.create("/invoices/${invoice.id}")).body(response)
    }

    private fun mapToResponse(invoice: Invoice): InvoiceResponse {
        return InvoiceResponse(
            id = invoice.id.toString(),
            total = invoice.total,
            store = StoreSmallResponse(
                id = invoice.store.id,
                name = invoice.store.name,
                cnpj = invoice.store.cnpj,
                address = invoice.store.address
            ),
            products = invoice.products.map {
                InvoiceProductResponse(
                    id = it.id.toString(),
                    name = it.product.name,
                    price = it.price,
                    sku = it.product.sku,
                    quantity = it.quantity
                )
            }
        )
    }

//    @PutMapping("/{id}")
//    fun updateInvoice(@PathVariable id: String, @RequestBody invoice: InvoiceRequest): Invoice {
//        return invoiceService.updateInvoice(id, Invoice(name = invoice.name, address = invoice.address))
//    }
//
//    @DeleteMapping("/{id}")
//    fun deleteInvoice(@PathVariable id: String) {
//        invoiceService.deleteInvoice(id)
//    }
}