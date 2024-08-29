package ams.view.facade

import ams.commons.TestFixtures
import ams.exception.ClientNotFoundException
import ams.service.ClientService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class ClientFacadeTest() {

    @Mock
    private lateinit var service: ClientService

    @InjectMocks
    private lateinit var facade: ClientFacade

    @Test
    fun `should return all customers`() {
        // Given
        val clients = TestFixtures.createTestDataBuilderForClientList()
        `when`(service.getAllClients()).thenReturn(clients)

        // When
        val customers = facade.getAllCustomers()

        // Then
        assertNotNull(customers)
        assertEquals(TestFixtures.VALID_ID, clients[0].id)
        assertEquals(TestFixtures.VALID_NAME_JOHN, clients[0].name)
        assertNull(clients[0].tradeName)
        assertEquals(TestFixtures.CPF1, clients[0].cpfCnpj)
        assertEquals(TestFixtures.PHONE1, clients[0].phone1)
    }

    @Test
    fun `should return empty list`() {
        // Given
        `when`(service.getAllClients()).thenThrow(ClientNotFoundException("No clients found"))

        // When
        val exception = assertThrows<ClientNotFoundException> {
            facade.getAllCustomers()
        }

        // Then
        assertEquals("No clients found", exception.message)
    }
}