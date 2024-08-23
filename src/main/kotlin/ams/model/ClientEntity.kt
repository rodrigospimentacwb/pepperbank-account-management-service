package ams.model

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "client")
class ClientEntity(
    var name: String,
    var socialName: String?,
    var tradeName: String?,
    var cpfCnpj: String,
    var email: String,
    var postalCode: String,
    var address: String,
    var city: String,
    var state: String,
    var propertyNumber: String?,
    var complement: String?,
    var phone1: String,
    var phone2: String?
) : BaseEntity() {

    fun validate() {
        require(name.isNotBlank()) { "Name cannot be blank" }
        require(cpfCnpj.isNotBlank()) { "CPF/CNPJ cannot be blank" }
        require(isValidCpfCnpj(cpfCnpj)) { "Invalid CPF/CNPJ" }
        require(email.isNotBlank()) { "Email cannot be blank" }
        require(postalCode.isNotBlank()) { "Postal code cannot be blank" }
        require(address.isNotBlank()) { "Address cannot be blank" }
        require(city.isNotBlank()) { "City cannot be blank" }
        require(state.isNotBlank()) { "State cannot be blank" }
        require(phone1.isNotBlank()) { "Phone1 cannot be blank" }

    }

    private fun isValidCpfCnpj(cpfCnpj: String): Boolean {
        val cpfRegex = Regex("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
        val cnpjRegex = Regex("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")

        return cpfRegex.matches(cpfCnpj) || cnpjRegex.matches(cpfCnpj)
    }
}