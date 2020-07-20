package br.com.ecommerce.livros.service.impl

import LivrosResponse
import br.com.ecommerce.livros.exception.GlobalExceptionNotFound
import br.com.ecommerce.livros.model.Livros
import br.com.ecommerce.livros.repository.LivrosRepository
import br.com.ecommerce.livros.service.LivrosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LivrosServiceImpl: LivrosService {

    @Autowired
    lateinit var livrosRepository: LivrosRepository

    override fun listAll(): LivrosResponse {
        var livros = livrosRepository.findAll().toList()
        var livrosResponse = LivrosResponse(livros)
        return livrosResponse
    }
    override fun saveLivros(livros: Livros): Livros {
        return this.livrosRepository.save(livros)
    }

    override fun updateLivros(livros: Livros, id: Long): Livros {
        this.deleteLivros(id)
        return this.saveLivros(livros)
    }
    override fun deleteLivros(id: Long) {
        this.livrosRepository.delete(Livros(id = id))
    }

    override fun findById(id: Long) : Livros?{
        val livros = this.livrosRepository.findById(id).orElseGet(
                throw GlobalExceptionNotFound("Livro não encontrado"))
        return livros;
    }
}