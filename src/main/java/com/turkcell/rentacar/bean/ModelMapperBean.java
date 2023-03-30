package com.turkcell.rentacar.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperBean {
    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
