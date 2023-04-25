package com.turkcell.rentacar.core.exceptionnew;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionResult<T>{
    private LocalDateTime timestamp;
    private String type;
    private T message;

    public ExceptionResult(String type,T message){
        timestamp = LocalDateTime.now();
        this.type = type;
        this.message = message;
    }

}
