package ams.repository

import ams.model.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<Client, Long> {
    fun findAllByOrderByIdAsc(): List<Client>
}