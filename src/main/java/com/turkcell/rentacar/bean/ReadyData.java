package com.turkcell.rentacar.bean;

import com.turkcell.rentacar.business.BrandService;
import com.turkcell.rentacar.business.CarService;
import com.turkcell.rentacar.business.ModelService;
import com.turkcell.rentacar.business.dto.request.BrandCreateRequest;
import com.turkcell.rentacar.business.dto.request.CarCreateRequest;
import com.turkcell.rentacar.business.dto.request.ModelCreateRequest;
import com.turkcell.rentacar.entity.Brand;
import com.turkcell.rentacar.entity.Model;
import com.turkcell.rentacar.entity.enums.State;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ReadyData {

    private final ModelMapper modelMapper;
    @Bean
    CommandLineRunner commandLineRunner(BrandService brandservice, ModelService modelService, CarService carService){
        return (args) -> {
            Brand mercedes = Brand.builder().name("Mercedes").build();
            Brand volvo = Brand.builder().name("Volvo").build();
            Brand toyota = Brand.builder().name("Toyota").build();
            brandservice.createBrand(modelMapper.map(mercedes, BrandCreateRequest.class));
            brandservice.createBrand(modelMapper.map(volvo, BrandCreateRequest.class));
            brandservice.createBrand(modelMapper.map(toyota, BrandCreateRequest.class));

            ModelCreateRequest c180 = ModelCreateRequest.builder().name("M-180").brandId(1l).build();
            ModelCreateRequest v100 = ModelCreateRequest.builder().name("V-100").brandId(2l).build();
            ModelCreateRequest t200 = ModelCreateRequest.builder().name("T-2000").brandId(3l).build();

            modelService.createModel(modelMapper.map(c180, ModelCreateRequest.class));
            modelService.createModel(modelMapper.map(v100, ModelCreateRequest.class));
            modelService.createModel(modelMapper.map(t200, ModelCreateRequest.class));


            CarCreateRequest car1 = CarCreateRequest.builder()
                    .state(State.RENTED)
                    .plate("76-DP-475")
                    .dailyPrice(5000)
                    .modelId(3L)
                    .modelYear(2018)
                    .build();

            CarCreateRequest car2 = CarCreateRequest.builder()
                    .state(State.MAINTANCE)
                    .plate("34-DP-475")
                    .dailyPrice(300)
                    .modelId(1L)
                    .modelYear(2018)
                    .build();


            carService.createCar(car2);
            carService.createCar(car1);







        };
    }
}
