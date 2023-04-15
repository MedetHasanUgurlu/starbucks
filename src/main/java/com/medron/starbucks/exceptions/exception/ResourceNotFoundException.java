package com.medron.starbucks.exceptions.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String fieldName;
    private String fieldValue;

    public ResourceNotFoundException(String fieldName,Long fieldValue) {
        super(String.format("%s not found with %d",fieldName,fieldValue));
    }
}
