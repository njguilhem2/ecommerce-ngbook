package br.com.ecommerce.livros.authorization.config

import br.com.ecommerce.livros.authorization.service.AutenticacaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@EnableWebSecurity
@Configuration
class SecurityConfiguration: WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var autenticacaoService: AutenticacaoService

    @Override
    @Bean
    override fun authenticationManager(): AuthenticationManager {
        return super.authenticationManager()
    }
   //Configurações de Autenticação
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(this.autenticacaoService).passwordEncoder(BCryptPasswordEncoder())
    }
    //Configuração de Autorização, URLS, diferenciar se é Stateless
    override fun configure(http: HttpSecurity?) {
        http!!.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(AutenticacaoViaTokenFilter()
                        ,UsernamePasswordAuthenticationFilter::class.java)
    }

    //Configuração de Recursos Estáticos css,imagens
    override fun configure(web: WebSecurity?) {
    }
}