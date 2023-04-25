package com.turkcell.rentacar.adapter;

import com.turkcell.rentacar.business.PosService;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class AkbankPosServiceAdapter implements PosService {
    @Override
    public boolean pay() {
        boolean result = new Random().nextBoolean();
        if(!result){
            throw new RuntimeException("Payment not accepted.");
        }
        return result;
    }
}
