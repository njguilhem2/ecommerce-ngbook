package br.com.ecommerce.livros.repository

import br.com.ecommerce.livros.model.Livros
import org.springframework.data.repository.CrudRepository

interface LivrosRepository: CrudRepository<Livros, Long> {
}