package ams.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class BaseEntityTest {

    private class TestEntity(
        id: Long? = null,
        createdOn: LocalDateTime = LocalDateTime.now(),
        updatedOn: LocalDateTime = LocalDateTime.now()
    ) : BaseEntity(id, createdOn, updatedOn)

    private lateinit var entity: TestEntity

    @BeforeEach
    fun setUp() {
        entity = TestEntity()
    }

    @Test
    fun `should initialize createdOn with current time`() {
        val now = LocalDateTime.now()
        assertTrue(entity.createdOn.isAfter(now.minusSeconds(1)) && entity.createdOn.isBefore(now.plusSeconds(1)),
            "createdOn should be initialized to current time")
    }

    @Test
    fun `should initialize updatedOn with current time`() {
        val now = LocalDateTime.now()
        assertTrue(entity.getUpdatedOn().isAfter(now.minusSeconds(1)) && entity.getUpdatedOn().isBefore(now.plusSeconds(1)),
            "updatedOn should be initialized to current time")
    }

    @Test
    fun `should update updatedOn on pre-update`() {
        val originalUpdatedOn = entity.getUpdatedOn()
        Thread.sleep(100)
        entity.onUpdate()
        val updatedUpdatedOn = entity.getUpdatedOn()

        assertTrue(updatedUpdatedOn.isAfter(originalUpdatedOn), "updatedOn should be updated after onUpdate call")
    }

    @Test
    fun `should have non-null id if provided`() {
        val entityWithId = TestEntity(id = 1L)
        assertEquals(1L, entityWithId.id, "id should be initialized correctly")
    }

    @Test
    fun `should have null id if not provided`() {
        assertNull(entity.id, "id should be null if not provided")
    }
}
