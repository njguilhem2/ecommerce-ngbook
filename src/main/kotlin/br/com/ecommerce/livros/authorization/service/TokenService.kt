package br.com.ecommerce.livros.authorization.service

import br.com.ecommerce.livros.model.Usuario
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import java.util.*

@Service
class TokenService {
    var expiration: Long = 180L
    @Value("\${book.jwt.secret}")
    lateinit var secret: String

    fun gerarToken(authentication: Authentication): String{
        val logado: Usuario = authentication.principal as Usuario
        val date = Date()
        val dateTime = date.time + expiration
        val dateExpiration = Date(dateTime)
        return Jwts.builder()
                .setIssuer("API ngBook")
                .setSubject(logado.id.toString())
                .setIssuedAt(dateExpiration)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS256,this.secret)
                .compact()
    }
}