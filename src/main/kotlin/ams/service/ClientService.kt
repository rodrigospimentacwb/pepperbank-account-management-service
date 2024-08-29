package ams.service

import ams.exception.ClientNotFoundException
import ams.model.Client
import ams.repository.ClientRepository
import org.springframework.stereotype.Service

@Service
class ClientService(val repository: ClientRepository) {

    fun getAllClients(): List<Client> {
        return repository.findAllByOrderByIdAsc().takeUnless { it.isEmpty() } ?: throw ClientNotFoundException("No clients found")
    }

    fun getClientById(id: Long): Client {
        return repository.findById(id).orElseThrow { throw ClientNotFoundException("Client with id $id not found") }
    }

}