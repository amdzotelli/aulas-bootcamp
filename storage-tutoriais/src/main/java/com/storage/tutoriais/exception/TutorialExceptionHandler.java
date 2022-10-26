package com.storage.tutoriais.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class TutorialExceptionHandler {

    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<ExceptionDetails> handlerInvalidParamException(InvalidParamException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Parâmetro Inválido.")
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDetails> handlerInvalidParamException(DataIntegrityViolationException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Dados Inválidos")
                        .message("Um ou mais dados fornecidos ferem as regras de integridade.")
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  HttpHeaders headers,
//                                                                  HttpStatus status,
//                                                                  WebRequest request) {
//        List<FieldError> error = ex.getFieldErrors();
//
//        return new ResponseEntity<>(
//                ExceptionDetails.builder()
//                        .title("Parâmetros inválidos.")
//                        .message("Um ou mais campos com valor inválido.")
//                        .fields(error.stream().map(FieldError::getField)
//                                .collect(Collectors.joining(";")))
//                        .fieldsMessage(error.stream().map(FieldError::getDefaultMessage)
//                                .collect(Collectors.joining(";")))
//                        .timestamp(LocalDateTime.now())
//                        .build(),
//                status
//        );
//    }

}
