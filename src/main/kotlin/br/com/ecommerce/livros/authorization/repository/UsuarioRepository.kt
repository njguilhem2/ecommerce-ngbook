package br.com.ecommerce.livros.authorization.repository

import br.com.ecommerce.livros.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UsuarioRepository: JpaRepository<Usuario, Long>{
    fun findByEmail(email: String): Optional<Usuario>
}