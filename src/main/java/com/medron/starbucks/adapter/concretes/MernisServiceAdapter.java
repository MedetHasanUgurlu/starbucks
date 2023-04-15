package com.medron.starbucks.adapter.concretes;

import com.medron.starbucks.adapter.abstracts.MernisService;
import com.medron.starbucks.adapter.mernis.BAAKPSPublicSoap;
import com.medron.starbucks.service.dto.request.CustomerCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MernisServiceAdapter implements MernisService {
    private final BAAKPSPublicSoap baakpsPublicSoap;
    private Long tc;
    private String name;
    private String surName;
    private int birthYear;
    @Override
    public void checkIdentity(CustomerCreateRequest request) {
        fillBlanks(request);
        try {

            if(!baakpsPublicSoap.TCKimlikNoDogrula(tc,name,surName,birthYear)){
                throw new RuntimeException("Mernis invalid Request");
            }
            System.out.println("Successfully");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);

        }
    }
    public void fillBlanks(CustomerCreateRequest request){
        this.tc = Long.valueOf(request.getNationalityId());
        this.name = request.getFirstName();
        this.surName = request.getLastName();
        this.birthYear = request.getDateOfBirth().getYear();
    }

}
