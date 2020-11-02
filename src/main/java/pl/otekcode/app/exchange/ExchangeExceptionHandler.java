package pl.otekcode.app.exchange;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
class ExchangeExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ExchangeCurrencyNotFoundException.class})
    public ResponseEntity<Object> handleConstraintViolation(
            ExchangeCurrencyNotFoundException ex, WebRequest request) {
        Map<String, String> map = new HashMap<>();
        map.put("status", HttpStatus.NOT_FOUND.name());
        map.put("message", "Currency code " + ex.getCode() + " not found in supported currencies");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}

