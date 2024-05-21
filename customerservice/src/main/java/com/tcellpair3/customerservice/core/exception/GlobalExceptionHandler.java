package com.tcellpair3.customerservice.core.exception;


import com.tcellpair3.customerservice.core.exception.details.BusinessExceptionDetails;
import com.tcellpair3.customerservice.core.exception.details.DateTimeParseExceptionDetails;
import com.tcellpair3.customerservice.core.exception.type.BusinessException;
import com.tcellpair3.customerservice.core.exception.type.DateTimeParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessExceptionDetails handleRuntimeException(BusinessException exception)
    {
        BusinessExceptionDetails businessExceptionDetails = new BusinessExceptionDetails();
        businessExceptionDetails.setTitle(exception.getMessage());
        return businessExceptionDetails;
    }
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DateTimeParseExceptionDetails handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        DateTimeParseExceptionDetails details = new DateTimeParseExceptionDetails();
        if (ex.getCause() instanceof DateTimeParseException) {
            DateTimeParseException dtpe = (DateTimeParseException) ex.getCause();
            details.setTitle(dtpe.getMessage());
        } else {
            details.setTitle(ex.getMessage());
        }
        return details;
    }
    // @Not blank için hazırlanan messageleri bastırır
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }


}