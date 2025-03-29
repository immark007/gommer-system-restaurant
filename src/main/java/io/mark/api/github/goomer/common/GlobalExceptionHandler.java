package io.mark.api.github.goomer.common;

import io.mark.api.github.goomer.dto.ErroCampo;
import io.mark.api.github.goomer.dto.ErroResposta;
import io.mark.api.github.goomer.exceptions.AcessoNegadoException;
import io.mark.api.github.goomer.exceptions.RestauranteDuplicadoException;
import io.mark.api.github.goomer.exceptions.UsuarioDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResposta handleMethodArgumentValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<ErroCampo> listaErros = fieldErrors.stream()
                .map(fe -> new ErroCampo(fe.getField(), fe.getDefaultMessage()))
                .toList();

        return new ErroResposta(HttpStatus.UNPROCESSABLE_ENTITY.name(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação", listaErros
        );
    }

    @ExceptionHandler(UsuarioDuplicadoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErroResposta handleUsuarioDuplicadoException(UsuarioDuplicadoException exception) {
        return ErroResposta.conflict(exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErroResposta handleErrosNaoTratados(RuntimeException exception) {
        return new ErroResposta(HttpStatus.INTERNAL_SERVER_ERROR.name(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro inesperado", List.of());
    }

    //Erro de Roles
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErroResposta handlerAcessDeniedException(AccessDeniedException ex){
        return new ErroResposta(HttpStatus.FORBIDDEN.name(), HttpStatus.FORBIDDEN.value(), "Acesso negado", List.of());
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErroResposta handlerInsufficientAuthenticationException(InsufficientAuthenticationException exception){
        return new ErroResposta(HttpStatus.UNAUTHORIZED.name(), HttpStatus.UNAUTHORIZED.value(), "Não autenticado", List.of());
    }

    @ExceptionHandler(RestauranteDuplicadoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErroResposta handlerRestauranteDuplicadoException(RestauranteDuplicadoException exception){
        return ErroResposta.conflict(exception.getMessage());
    }

    @ExceptionHandler(AcessoNegadoException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErroResposta handlerAcessoNegadoException(AcessoNegadoException exception){
        return ErroResposta.Forbidden(exception.getMessage());
    }


}
