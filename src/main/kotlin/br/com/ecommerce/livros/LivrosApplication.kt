package br.com.ecommerce.livros

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootApplication
class LivrosApplication

fun main(args: Array<String>) {
	runApplication<LivrosApplication>(*args)
}
