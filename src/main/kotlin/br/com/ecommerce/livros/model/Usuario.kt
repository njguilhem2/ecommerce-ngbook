package br.com.ecommerce.livros.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*

@Entity
class Usuario : UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 1L
    val nome: String = ""
    val email: String = ""
    val senha: String = ""

    @ManyToMany(fetch = FetchType.EAGER)
    val perfis: List<Perfis> = ArrayList()

    override fun getAuthorities(): Collection<out GrantedAuthority> {
        return this.perfis
    }

    override fun isEnabled(): Boolean {
       return true
    }

    override fun getUsername(): String {
        return this.email
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
       return this.senha
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}