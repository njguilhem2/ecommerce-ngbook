package br.com.ecommerce.livros.model

import org.springframework.security.core.GrantedAuthority
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Perfis: GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 1L
    val nome: String = ""

    override fun getAuthority(): String {
        return this.nome
    }
}