package ams

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class AccountManagementServiceApplication

fun main(args: Array<String>) {
	runApplication<AccountManagementServiceApplication>(*args)
}
