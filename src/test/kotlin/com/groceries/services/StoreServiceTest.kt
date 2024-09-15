package com.groceries.services

import com.groceries.exeptions.EntityNotFoundException
import com.groceries.models.Store
import com.groceries.repositories.StoreRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class StoreServiceTest {

    @Mock
    lateinit var storeRepository: StoreRepository

    @InjectMocks
    lateinit var storeService: StoreService

    @Test
    fun `test getStores returns list of stores`() {
        val stores = listOf(mockStore(), mockStore())
        `when`(storeRepository.findAll()).thenReturn(stores)

        val result = storeService.getStores()

        assertThat(stores).isEqualTo(result)
        verify(storeRepository, times(1)).findAll()
    }

    @Test
    fun `test getStore returns store when found`() {
        val id = UUID.randomUUID()
        val store = mockStore()
        `when`(storeRepository.findById(id)).thenReturn(Optional.of(store))

        val result = storeService.getStore(id.toString())

        assertThat(store).isEqualTo(result)
        verify(storeRepository, times(1)).findById(id)
    }

    @Test
    fun `test getStore throws RuntimeException when not found`() {
        val id = UUID.randomUUID()
        `when`(storeRepository.findById(id)).thenReturn(Optional.empty())

        val exception = assertThrows(RuntimeException::class.java) {
            storeService.getStore(id.toString())
        }

        assertThat(exception.message).isEqualTo("Store not found")
        verify(storeRepository, times(1)).findById(id)
    }

    @Test
    fun `test createStore returns saved store`() {
        val store = mockStore()
        `when`(storeRepository.save(store)).thenReturn(store)

        val result = storeService.createStore(store)

        assertThat(store).isEqualTo(result)
        verify(storeRepository, times(1)).save(store)
    }

    @Test
    fun `test updateStore returns updated store`() {
        val existingStore = mockStore()
        val updatedStore = existingStore.copy(address = "Address2")
        val id = existingStore.id.let { it!! }
        `when`(storeRepository.findById(id)).thenReturn(Optional.of(existingStore))
        `when`(storeRepository.save(any(Store::class.java))).thenReturn(updatedStore)

        val result = storeService.updateStore(id.toString(), updatedStore)

        assertThat(updatedStore).isEqualTo(result)
        verify(storeRepository, times(1)).findById(id)
        verify(storeRepository, times(1)).save(any(Store::class.java))
    }

    @Test
    fun `test deleteStore deletes store when found`() {
        val id = UUID.randomUUID()
        `when`(storeRepository.existsById(id)).thenReturn(true)

        storeService.deleteStore(id.toString())

        verify(storeRepository, times(1)).existsById(id)
        verify(storeRepository, times(1)).deleteById(id)
    }

    @Test
    fun `test deleteStore throws RuntimeException when not found`() {
        val id = UUID.randomUUID()
        `when`(storeRepository.existsById(id)).thenReturn(false)

        val exception = assertThrows(RuntimeException::class.java) {
            storeService.deleteStore(id.toString())
        }

        assertThat(exception.message).isEqualTo("Store not found")
        verify(storeRepository, times(1)).existsById(id)
        verify(storeRepository, times(0)).deleteById(id)
    }

    @Test
    fun `test getStoreByCNPJ returns store when found`() {
        val storeCNPJ = "12345678901234"
        val store = mockStore()
        `when`(storeRepository.getStoreByCnpj(storeCNPJ)).thenReturn(Optional.of(store))

        val result = storeService.getStoreByCNPJ(storeCNPJ)

        assertThat(store).isEqualTo(result)
        verify(storeRepository, times(1)).getStoreByCnpj(storeCNPJ)
    }

    @Test
    fun `test getStoreByCNPJ throws EntityNotFoundException when not found`() {
        val storeCNPJ = "12345678901234"
        `when`(storeRepository.getStoreByCnpj(storeCNPJ)).thenReturn(Optional.empty())

        val exception = assertThrows(EntityNotFoundException::class.java) {
            storeService.getStoreByCNPJ(storeCNPJ)
        }

        assertThat(exception.message).isEqualTo("Store not found")
        verify(storeRepository, times(1)).getStoreByCnpj(storeCNPJ)
    }

    private fun mockStore(): Store {
        return Store(
            id = UUID.randomUUID(),
            name = "Store1",
            address = "Address1",
            cnpj = "12345678901234"
        )
    }
}