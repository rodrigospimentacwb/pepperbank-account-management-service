package ams.integrationTest

import ams.commons.TestFixtures
import ams.model.Client
import ams.repository.ClientRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClientRepositoryIntegrationTest(
    @Autowired val clientRepository: ClientRepository
) {

    @Test
    fun `should find client by cpfCnpj`() {
        // Given
        val client = TestFixtures.createTestDataBuilderForClient()
        clientRepository.save(client)

        // When
        val foundClient: Client = client.id?.let { clientRepository.findById(it).orElseThrow {
            NoSuchElementException("Client not found for ID $it")
        }} ?: throw IllegalArgumentException("Client ID cannot be null")

        // Then
        assertNotNull(foundClient)
        assertEquals(TestFixtures.CPF1, foundClient.cpfCnpj)
    }
}