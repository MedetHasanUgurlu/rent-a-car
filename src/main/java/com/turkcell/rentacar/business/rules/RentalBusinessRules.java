package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RentalBusinessRules {
    private final RentalRepository repository;
}
