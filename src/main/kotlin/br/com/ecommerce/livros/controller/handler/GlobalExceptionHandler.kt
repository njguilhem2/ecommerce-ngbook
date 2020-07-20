package br.com.ecommerce.livros.controller.handler

import br.com.ecommerce.livros.exception.GlobalExceptionNotFound
import br.com.ecommerce.livros.model.GlobalGenericError
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestControllerAdvice
class GlobalExceptionHandler {

    val NOT_FOUND : String = "Not Found"
    @ExceptionHandler(GlobalExceptionNotFound::class)
    fun GlobalExceptionNotFound(serveletRequest: HttpServletRequest,
                                servletResponse: HttpServletResponse,
                                exception: Exception) : ResponseEntity<GlobalGenericError> {
        return ResponseEntity(GlobalGenericError(404, this.NOT_FOUND,
                exception.message ?: "invalid json"), HttpStatus.NOT_FOUND)
    }
}