package dio.avanade.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorResponse("Recurso não encontrado", ex.getMessage(), HttpStatus.NOT_FOUND.value()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorResponse("Requisição inválida", ex.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ErrorResponse("Erro interno do servidor", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    // Classe interna para resposta padronizada de erro
    static class ErrorResponse {
        private String error;
        private String message;
        private int status;
        private LocalDateTime timestamp;

        public ErrorResponse(String error, String message, int status) {
            this.error = error;
            this.message = message;
            this.status = status;
            this.timestamp = LocalDateTime.now();
        }

        public String getError() { return error; }
        public String getMessage() { return message; }
        public int getStatus() { return status; }
        public LocalDateTime getTimestamp() { return timestamp; }
    }
}
