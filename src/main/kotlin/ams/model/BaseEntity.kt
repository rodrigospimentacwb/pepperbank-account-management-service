package ams.model

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PreUpdate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, updatable = false)
    val createdOn: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    private var updatedOn: LocalDateTime = LocalDateTime.now()) {

    @PreUpdate
    fun onUpdate() {
        updatedOn = LocalDateTime.now();
    }

    fun getUpdatedOn(): LocalDateTime {
        return updatedOn
    }
}