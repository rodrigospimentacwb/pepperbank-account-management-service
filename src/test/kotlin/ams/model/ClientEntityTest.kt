package ams.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ClientEntityTest {

    @Test
    fun `should throw exception if name is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            createTestDataBuilderForClient(name = "").validate()
        }
        assertEquals("Name cannot be blank", exception.message)
    }

    @Test
    fun `should throw exception if cpfCnpj is invalid`() {
        val exception = assertThrows<IllegalArgumentException> {
            createTestDataBuilderForClient(cpfCnpj = "12345678900").validate()
        }
        assertEquals("Invalid CPF/CNPJ", exception.message)
    }

    @Test
    fun `should throw exception if cpfCnpj is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            createTestDataBuilderForClient(cpfCnpj = "").validate()
        }
        assertEquals("CPF/CNPJ cannot be blank", exception.message)
    }

    @Test
    fun `should throw exception if email is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            createTestDataBuilderForClient(email = "").validate()
        }
        assertEquals("Email cannot be blank", exception.message)
    }

    @Test
    fun `should throw exception if postalCode is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            createTestDataBuilderForClient(postalCode = "").validate()
        }
        assertEquals("Postal code cannot be blank", exception.message)
    }

    @Test
    fun `should throw exception if address is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            createTestDataBuilderForClient(address = "").validate()
        }
        assertEquals("Address cannot be blank", exception.message)
    }

    @Test
    fun `should throw exception if city is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            createTestDataBuilderForClient(city = "").validate()
        }
        assertEquals("City cannot be blank", exception.message)
    }

    @Test
    fun `should throw exception if state is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            createTestDataBuilderForClient(state = "").validate()
        }
        assertEquals("State cannot be blank", exception.message)
    }

    @Test
    fun `should throw exception if phone1 is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            createTestDataBuilderForClient(phone1 = "").validate()
        }
        assertEquals("Phone1 cannot be blank", exception.message)
    }

    @Test
    fun `should validate valid client entity`() {
        val client = createTestDataBuilderForClient()
        client.validate()
    }

    private fun createTestDataBuilderForClient(
        name: String = "Valid Name",
        socialName: String? = null,
        tradeName: String? = null,
        cpfCnpj: String = "123.456.789-00",
        email: String = "valid@example.com",
        postalCode: String = "54321-678",
        address: String = "Valid Address",
        city: String = "Valid City",
        state: String = "VC",
        propertyNumber: String? = null,
        complement: String? = null,
        phone1: String = "987654321",
        phone2: String? = null
    ): ClientEntity {
        return ClientEntity(
            name = name,
            socialName = socialName,
            tradeName = tradeName,
            cpfCnpj = cpfCnpj,
            email = email,
            postalCode = postalCode,
            address = address,
            city = city,
            state = state,
            propertyNumber = propertyNumber,
            complement = complement,
            phone1 = phone1,
            phone2 = phone2
        )
    }
}
