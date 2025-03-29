package io.mark.api.github.goomer.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErroResposta(String status, int codeStatus, String message, List<ErroCampo> erros) {

    //Conflito
    public static ErroResposta conflict(String message){
        return new ErroResposta(HttpStatus.CONFLICT.name(), HttpStatus.CONFLICT.value(), message, List.of());
    }

    //BadRequest
    public static ErroResposta BadRequest(String message){
        return new ErroResposta(HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.value(), message, List.of());
    }

    //FORBIDEN
    public static ErroResposta Forbidden(String message){
        return new ErroResposta(HttpStatus.FORBIDDEN.name(), HttpStatus.FORBIDDEN.value(), message, List.of());
    }
}
