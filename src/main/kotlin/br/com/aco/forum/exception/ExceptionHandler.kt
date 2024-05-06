package br.com.aco.forum.exception

import br.com.aco.forum.dto.ErrorDtoResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(
        e: NotFoundException,
        request: HttpServletRequest
    ): ErrorDtoResponse {
        return ErrorDtoResponse(
            status = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = e.message!!,
            path = request.servletPath
        )
    }


    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleNotFound(
        e: Exception,
        request: HttpServletRequest
    ): ErrorDtoResponse {
        return ErrorDtoResponse(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = e.message!!,
            path = request.servletPath
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleValidationError(
        e: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ErrorDtoResponse {
        val errorMessaage = HashMap<String, String?>()
        e.bindingResult.fieldErrors.forEach { error ->
            errorMessaage[error.field] = error.defaultMessage}


            return ErrorDtoResponse(
                status = HttpStatus.BAD_REQUEST.value(),
                error = HttpStatus.BAD_REQUEST.name,
                message = errorMessaage.toString(),
                path = request.servletPath
            )
        }
    }
