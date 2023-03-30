package com.turkcell.rentacar.bean;

import com.turkcell.rentacar.business.BrandService;
import com.turkcell.rentacar.business.ModelService;
import com.turkcell.rentacar.business.dto.request.BrandCreateRequest;
import com.turkcell.rentacar.entity.Brand;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ReadyData {

    private final ModelMapper modelMapper;
    @Bean
    CommandLineRunner commandLineRunner(BrandService brandservice, ModelService modelService){
        return (args) -> {
            Brand mercedes = Brand.builder().name("Mercedes").build();
            Brand volvo = Brand.builder().name("Volvo").build();
            Brand toyota = Brand.builder().name("Toyota").build();
            brandservice.createBrand(modelMapper.map(mercedes, BrandCreateRequest.class));
            brandservice.createBrand(modelMapper.map(volvo, BrandCreateRequest.class));
            brandservice.createBrand(modelMapper.map(toyota, BrandCreateRequest.class));

        };
    }
}
