package com.soham.demo.StudentServer.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponseDTO {
    public LocalDateTime timestamp;
    private int statusCode;
    private String  error;
    private String path;
    private String message;

}
