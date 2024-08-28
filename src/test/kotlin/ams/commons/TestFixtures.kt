package ams.commons

import ams.model.BaseEntity
import ams.model.Client
import ams.view.dto.ClientDTO

class TestFixtures {

    companion object {

        val VALID_ID: Long = 1L
        val VALID_NAME_JOHN: String = "John Doo"
        val VALID_NAME_MARY: String = "Mary Ane"
        val VALID_NAME_COMPANY: String = "Company CO."
        val SOCIAL_NAME: String = "Valid Social Name"
        val TRADE_NAME: String = "Company Good"
        val CPF1: String = "01234567890"
        val CPF2: String = "11111111111"
        val CNPJ: String = "99999999000191"
        val EMAIL: String = "valid@example.com"
        val POSTAL_CODE: String = "54321678"
        val ADDRESS: String = "Valid Address"
        val CITY: String = "Valid City"
        val STATE: String = "VC"
        val PROPERTY_NUMBER: String? = null
        val COMPLEMENT: String? = null
        val PHONE1: String = "987654321"
        val PHONE2: String? = null

        fun createTestDataBuilderForClient(
            id: Long? = VALID_ID,
            name: String = VALID_NAME_JOHN,
            socialName: String? = null,
            tradeName: String? = null,
            cpfCnpj: String = CPF1,
            email: String = EMAIL,
            postalCode: String = POSTAL_CODE,
            address: String = ADDRESS,
            city: String = CITY,
            state: String = STATE,
            propertyNumber: String? = null,
            complement: String? = null,
            phone1: String = PHONE1,
            phone2: String? = null
        ): Client {

            val client = Client(
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

            if (id != null) {
                val field = BaseEntity::class.java.getDeclaredField("id")
                field.isAccessible = true
                field.set(client, id)
            }

            return client;
        }

        fun createTestDataBuilderForClientList(): List<Client> {
            return listOf(
                createTestDataBuilderForClient(id = VALID_ID, name = VALID_NAME_JOHN, cpfCnpj = CPF1),
                createTestDataBuilderForClient(id = 2L, name = VALID_NAME_MARY, cpfCnpj = CPF2),
                createTestDataBuilderForClient(id = 3L, name = VALID_NAME_COMPANY, cpfCnpj = CNPJ, tradeName = TRADE_NAME),
            )
        }

        fun createTestDataBuilderForClientListDTO(): List<ClientDTO> {
            return listOf(
                createTestDataBuilderForClientDTO(id = VALID_ID, name = VALID_NAME_JOHN, cpfCnpj = CPF1),
                createTestDataBuilderForClientDTO(id = 2L, name = VALID_NAME_MARY, cpfCnpj = CPF2),
                createTestDataBuilderForClientDTO(id = 3L, name = VALID_NAME_COMPANY, cpfCnpj = CNPJ, tradeName = TRADE_NAME),
            )
        }

        fun createTestDataBuilderForClientDTO(
            id: Long? = VALID_ID,
            name: String = VALID_NAME_JOHN,
            tradeName: String? = null,
            cpfCnpj: String = CPF1,
            phone: String = PHONE1
        ): ClientDTO {
            return ClientDTO(
                id = id,
                name = name,
                tradeName = tradeName,
                cpfCnpj = cpfCnpj,
                phone = phone
            )
        }
    }
}