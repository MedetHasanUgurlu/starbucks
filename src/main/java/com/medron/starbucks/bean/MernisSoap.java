package com.medron.starbucks.bean;

import com.medron.starbucks.adapter.mernis.BAAKPSPublicSoap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MernisSoap {

    @Bean
    BAAKPSPublicSoap baakpsPublicSoap(){
        return new BAAKPSPublicSoap();
    }
}
