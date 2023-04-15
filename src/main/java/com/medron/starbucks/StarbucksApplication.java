package com.medron.starbucks;

import com.medron.starbucks.adapter.abstracts.MernisService;
import com.medron.starbucks.adapter.concretes.MernisServiceAdapter;
import com.medron.starbucks.adapter.mernis.BAAKPSPublicSoap;
import com.medron.starbucks.service.dto.request.CustomerCreateRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class StarbucksApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarbucksApplication.class, args);

	}

}
