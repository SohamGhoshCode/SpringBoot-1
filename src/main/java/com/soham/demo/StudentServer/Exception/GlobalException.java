package com.soham.demo.StudentServer.Exception;

import com.soham.demo.StudentServer.DTO.ExceptionResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponseDTO> handleEmailException(
            EmailAlreadyExistsException e,
            HttpServletRequest req) {

        ExceptionResponseDTO dto = new ExceptionResponseDTO(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                req.getRequestURI(),   // ✔ path
                e.getMessage()         // ✔ message
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponseDTO> handleDBException(
            DataIntegrityViolationException e,
            HttpServletRequest req) {

        ExceptionResponseDTO dto = new ExceptionResponseDTO(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                req.getRequestURI(),
                "Email already exists (DB constraint)"
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDTO> handleRuntimeException(
            RuntimeException e,
            HttpServletRequest req) {

        ExceptionResponseDTO dto = new ExceptionResponseDTO(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                req.getRequestURI(),
                e.getMessage()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }
}