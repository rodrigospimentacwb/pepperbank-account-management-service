package ams.view.controller

import ams.view.dto.ClientDTO
import ams.view.facade.ClientFacade
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customers")
class ClientController(val facade: ClientFacade) {

    @GetMapping
    fun getAllCustomers(): ResponseEntity<List<ClientDTO>> {
        val clients = facade.getAllCustomers()
        return ResponseEntity.ok(clients)
    }
}