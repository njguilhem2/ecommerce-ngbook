package br.com.ecommerce.livros.authorization.form

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

data class LofingForm (
    val email: String,
    val senha: String
) {
    fun converter(): UsernamePasswordAuthenticationToken {
            return UsernamePasswordAuthenticationToken(email,senha)
    }
}
