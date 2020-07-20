package br.com.ecommerce.livros.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Livros(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 1,
        val nome: String = "",
        val titulo: String = "",
        val descricao: String = "",
        val preco: Double = 0.0
)