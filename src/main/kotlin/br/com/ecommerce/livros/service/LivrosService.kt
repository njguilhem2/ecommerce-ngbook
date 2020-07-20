package br.com.ecommerce.livros.service

import LivrosResponse
import br.com.ecommerce.livros.model.Livros

interface LivrosService {
    fun listAll(): LivrosResponse
    fun saveLivros(livros: Livros): Livros
    fun updateLivros(livros: Livros, id: Long): Livros
    fun deleteLivros(id: Long)
    fun findById(id: Long): Livros?
}