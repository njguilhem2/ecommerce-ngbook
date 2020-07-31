package br.com.ecommerce.livros.controller

import LivrosResponse
import br.com.ecommerce.livros.model.Livros
import br.com.ecommerce.livros.service.LivrosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/livros")
class LivrosController {

    @Autowired
    lateinit var livrosService: LivrosService

    @GetMapping ()
    fun getLivros(): ResponseEntity<LivrosResponse?>{
        return ResponseEntity(this.livrosService.listAll(), HttpStatus.OK)
    }
    @PostMapping()
    fun postLivros(@RequestBody livros:Livros): ResponseEntity<Livros>{
        return ResponseEntity(this.livrosService.saveLivros(livros = livros),HttpStatus.CREATED)
    }
    @PutMapping("/{id}")
    fun putLivros(@RequestBody livros: Livros, @PathVariable("id") id: Long):
            ResponseEntity<Livros>{
        return ResponseEntity(this.livrosService.updateLivros(livros = livros, id = id)
                , HttpStatus.OK)
    }
    @DeleteMapping("/{id}")
    fun deleteLivros(@PathVariable("id") id : Long): ResponseEntity<Unit>{
        return ResponseEntity(this.livrosService.deleteLivros(id = id)
                , HttpStatus.NO_CONTENT)
    }
    @GetMapping("/{id}")
    fun getByIdLivros(@PathVariable("id") id : Long):
            ResponseEntity<Livros>{
        return ResponseEntity(this.livrosService.findById(id),HttpStatus.OK)
    }
}