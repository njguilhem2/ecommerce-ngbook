package br.com.ecommerce.livros.authorization.controller

import br.com.ecommerce.livros.authorization.form.LofingForm
import br.com.ecommerce.livros.model.TokenDto
import br.com.ecommerce.livros.authorization.service.TokenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.naming.AuthenticationException

@RestController
@RequestMapping("/auth")
class AutenticacaoController{
    @Autowired
    lateinit var authenticationManager: AuthenticationManager

    @Autowired
    lateinit var tokenService: TokenService

    @PostMapping
    fun autenticar(@RequestBody form: LofingForm): ResponseEntity<TokenDto>{

        val dadosLogin: UsernamePasswordAuthenticationToken = form.converter()

        try {
            val authentication = this.authenticationManager.authenticate(dadosLogin)
            val token:String = tokenService.gerarToken(authentication)
            println(token)
            return ResponseEntity.ok(TokenDto(token,"Bearer"))

        }catch (e: AuthenticationException) {
            return ResponseEntity.badRequest().build()
        }
    }
}