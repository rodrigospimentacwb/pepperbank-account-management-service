package ams.model

import ams.commons.TestFixtures
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ClientTest {

    @Test
    fun `should throw exception if name is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            TestFixtures.createTestDataBuilderForClient(name = "").validate()
        }
        assertEquals("Name cannot be blank", exception.message)
    }

    @Test
    fun `should throw exception if cpfCnpj is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            TestFixtures.createTestDataBuilderForClient(cpfCnpj = "").validate()
        }
        assertEquals("CPF/CNPJ cannot be blank", exception.message)
    }

    @Test
    fun `should throw exception if email is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            TestFixtures.createTestDataBuilderForClient(email = "").validate()
        }
        assertEquals("Email cannot be blank", exception.message)
    }

    @Test
    fun `should throw exception if postalCode is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            TestFixtures.createTestDataBuilderForClient(postalCode = "").validate()
        }
        assertEquals("Postal code cannot be blank", exception.message)
    }

    @Test
    fun `should throw exception if address is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            TestFixtures.createTestDataBuilderForClient(address = "").validate()
        }
        assertEquals("Address cannot be blank", exception.message)
    }

    @Test
    fun `should throw exception if city is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            TestFixtures.createTestDataBuilderForClient(city = "").validate()
        }
        assertEquals("City cannot be blank", exception.message)
    }

    @Test
    fun `should throw exception if state is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            TestFixtures.createTestDataBuilderForClient(state = "").validate()
        }
        assertEquals("State cannot be blank", exception.message)
    }

    @Test
    fun `should throw exception if phone1 is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            TestFixtures.createTestDataBuilderForClient(phone1 = "").validate()
        }
        assertEquals("Phone1 cannot be blank", exception.message)
    }

    @Test
    fun `should validate valid client entity`() {
        val client = TestFixtures.createTestDataBuilderForClient()
        client.validate()
    }


}
