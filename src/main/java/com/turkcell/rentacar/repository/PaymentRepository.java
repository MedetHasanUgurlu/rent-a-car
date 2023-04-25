package com.turkcell.rentacar.repository;

import com.turkcell.rentacar.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    boolean existsByCardNumber(String cardNumber);
    Payment findByCardNumber(String cardNumber);
    boolean existsByCardNumberAndAndCardHolderAndAndCvvAndExpreationMonthAndExpreationYear(
            String cardNumber,String cardHolder, String cvv, int expreationMonth, int expreationYear
    );
}
