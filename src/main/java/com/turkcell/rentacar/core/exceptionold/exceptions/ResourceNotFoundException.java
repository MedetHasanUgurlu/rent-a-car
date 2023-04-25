package com.turkcell.rentacar.core.exceptionold.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/*
@Getter
@Setter
@ResponseStatus(HttpStatus.NOT_FOUND)

 */
public class ResourceNotFoundException extends RuntimeException {

    /*
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(String fieldName, Long fieldValue) {
        super(String.format("In %s table Id: %s not found.", fieldName,fieldValue));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    */

}
