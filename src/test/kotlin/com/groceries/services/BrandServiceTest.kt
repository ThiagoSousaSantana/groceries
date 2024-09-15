package com.groceries.services

import com.groceries.exeptions.EntityNotFoundException
import com.groceries.models.Brand
import com.groceries.repositories.BrandRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class BrandServiceTest {

    @Mock
    lateinit var brandRepository: BrandRepository

    @InjectMocks
    lateinit var brandService: BrandService

    @Test
    fun `test findAll returns list of brands`() {
        val brands = listOf(Brand(UUID.randomUUID(), "Brand1"), Brand(UUID.randomUUID(), "Brand2"))
        `when`(brandRepository.findAll()).thenReturn(brands)

        val result = brandService.findAll()

        assertThat(brands).isEqualTo(result)
        verify(brandRepository, times(1)).findAll()
    }

    @Test
    fun `test findById returns brand when found`() {
        val id = UUID.randomUUID()
        val brand = Brand(id, "Brand1")
        `when`(brandRepository.findById(id)).thenReturn(Optional.of(brand))

        val result = brandService.findById(id)

        assertThat(brand).isEqualTo(result)
        verify(brandRepository, times(1)).findById(id)
    }

    @Test
    fun `test findById throws EntityNotFoundException when not found`() {
        val id = UUID.randomUUID()
        `when`(brandRepository.findById(id)).thenReturn(Optional.empty())

        val exception = assertThrows(EntityNotFoundException::class.java) {
            brandService.findById(id)
        }

        assertThat(exception.message).isEqualTo("Brand not found")
        verify(brandRepository, times(1)).findById(id)
    }

    @Test
    fun `test save returns saved brand`() {
        val brand = Brand(UUID.randomUUID(), "Brand1")
        `when`(brandRepository.save(brand)).thenReturn(brand)

        val result = brandService.save(brand)

        assertThat(brand).isEqualTo(result)
        verify(brandRepository, times(1)).save(brand)
    }
}