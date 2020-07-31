package br.com.ecommerce.livros.authorization.service

import br.com.ecommerce.livros.model.Usuario
import br.com.ecommerce.livros.authorization.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class AutenticacaoService: UserDetailsService {
    @Autowired
    lateinit var repository: UsuarioRepository

    override fun loadUserByUsername(usuario: String): UserDetails {
       val usuarioEncontrado: Optional<Usuario> = this.repository.findByEmail(usuario)
        if (usuarioEncontrado.isPresent){
            return usuarioEncontrado.get()
        }
        throw UsernameNotFoundException("Usuário não encontrado")
    }
}