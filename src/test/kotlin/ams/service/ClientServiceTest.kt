package ams.service

import ams.commons.TestFixtures
import ams.exception.ClientNotFoundException
import ams.repository.ClientRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.anyLong
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class ClientServiceTest() {

    @Mock
    private lateinit var repository: ClientRepository

    @InjectMocks
    private lateinit var service: ClientService

    @Test
    fun `should return all customers`() {
        // Given
        val clients = TestFixtures.createTestDataBuilderForClientList()
        `when`(repository.findAll()).thenReturn(clients)

        // When
        val result = service.getAllClients()

        // Then
        assert(result == clients)
        assertEquals(TestFixtures.VALID_ID, clients[0].id)
        assertEquals(3, clients.size)
    }

    @Test
    fun `should return empty list`() {
        // Given
        `when`(repository.findAll()).thenReturn(emptyList())

        // When
        val exception = assertThrows<ClientNotFoundException> {
            service.getAllClients()
        }

        // Then
        assertEquals("No clients found", exception.message)
    }

    @Test
    fun `should return client when found by id`() {
        // Given
        val client = TestFixtures.createTestDataBuilderForClient()
        `when`(repository.findById(TestFixtures.VALID_ID)).thenReturn(Optional.of(client))

        // When
        val result = service.getClientById(TestFixtures.VALID_ID)

        // Then
        assert(result == client)
        assertEquals(TestFixtures.VALID_ID, client.id)
    }

    @Test
    fun `should throw exception when client not found by id`() {
        // Given
        `when`(repository.findById(anyLong())).thenReturn(Optional.empty())

        // When
        val exception = assertThrows<ClientNotFoundException> {
            service.getClientById(10L)
        }

        // Then
        assertEquals("Client with id 10 not found", exception.message)
    }
}