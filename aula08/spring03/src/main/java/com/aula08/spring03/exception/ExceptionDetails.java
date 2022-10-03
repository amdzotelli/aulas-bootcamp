package com.aula08.spring03.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data // inclui Getters, Setters, ToString, Equals...
@Builder
public class ExceptionDetails {
    private String title;
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
