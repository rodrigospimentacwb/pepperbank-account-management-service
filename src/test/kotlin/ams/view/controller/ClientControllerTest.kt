package ams.view.controller

import ams.commons.TestFixtures
import ams.exception.ClientNotFoundException
import ams.view.facade.ClientFacade
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(ClientController::class)
class ClientControllerTest() {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var clientFacade: ClientFacade

    @Test
    fun `should return all customers`() {
        // Given
        val clients = TestFixtures.createTestDataBuilderForClientListDTO()
        `when`(clientFacade.getAllCustomers()).thenReturn(clients)

        // Act & Assert
        mockMvc.perform(get("/api/v1/customers")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].id").value(clients[0].id))
            .andExpect(jsonPath("$[0].name").value(clients[0].name))
            .andExpect(jsonPath("$[1].id").value(clients[1].id))
            .andExpect(jsonPath("$[1].name").value(clients[1].name))

        verify(clientFacade, times(1)).getAllCustomers()
    }

    @Test
    fun `should return empty list`() {
        // Given
        `when`(clientFacade.getAllCustomers()).thenThrow(ClientNotFoundException("No clients found"))

        // Act & Assert
        mockMvc.perform(get("/api/v1/customers")
            .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isNotFound)
            .andExpect(content().string("No clients found"))

        verify(clientFacade, times(1)).getAllCustomers()
    }

}