package ams.view.dto

import ams.commons.TestFixtures
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class ClientDTOTest {

    @Test
    fun `should create a PF client DTO`() {
        // Given
        val clientDTO = TestFixtures.createTestDataBuilderForClientDTO()

        // Then
        assertNotNull(clientDTO)
        assertEquals(1, clientDTO.id)
        assertEquals(TestFixtures.VALID_NAME_JOHN, clientDTO.name)
        assertEquals(TestFixtures.CPF1, clientDTO.cpfCnpj)
        assertEquals(TestFixtures.PHONE1, clientDTO.phone)
    }

    @Test
    fun `should create a PJ client DTO`() {
        // Given
        val clientDTO = TestFixtures.createTestDataBuilderForClientDTO(name = TestFixtures.VALID_NAME_COMPANY, cpfCnpj = TestFixtures.CNPJ, tradeName = TestFixtures.TRADE_NAME)

        // Then
        assertNotNull(clientDTO)
        assertEquals(1, clientDTO.id)
        assertEquals(TestFixtures.VALID_NAME_COMPANY, clientDTO.name)
        assertEquals(TestFixtures.TRADE_NAME, clientDTO.tradeName)
        assertEquals(TestFixtures.CNPJ, clientDTO.cpfCnpj)
        assertEquals(TestFixtures.PHONE1, clientDTO.phone)
    }
}