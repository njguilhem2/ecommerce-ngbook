package br.com.ecommerce.livros.authorization.config

import org.springframework.expression.spel.ast.NullLiteral
import org.springframework.util.ObjectUtils
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AutenticacaoViaTokenFilter: OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filter: FilterChain) {

        val token: String? = recuperarToken(request)
        filter.doFilter(request,response)
    }

    private fun recuperarToken(request: HttpServletRequest): String? {
        val token: String = request.getHeader("Authorization")
        if(ObjectUtils.isEmpty(token) || !token.startsWith("Bearer ")){
            return null
        }
        return token.substring(7, token.length)
    }
}