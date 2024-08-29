package ams.view.facade

import ams.model.Client
import ams.service.ClientService
import ams.view.dto.ClientDTO
import org.springframework.stereotype.Component

@Component
class ClientFacade(private val customerService: ClientService) {

    fun getAllCustomers(): List<ClientDTO> {
        return customerService.getAllClients().map { toDto(it) }
    }

    private fun toDto(client: Client): ClientDTO {
        return client.let {
            ClientDTO(
                id = it.id,
                name = it.name,
                tradeName = it.tradeName,
                cpfCnpj = it.cpfCnpj,
                phone = it.phone1
            )
        }
    }

}