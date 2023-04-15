package com.medron.starbucks.service.impl;

import com.medron.starbucks.adapter.abstracts.MernisService;
import com.medron.starbucks.entity.Customer;
import com.medron.starbucks.exceptions.exception.ResourceNotFoundException;
import com.medron.starbucks.repository.CustomerRepository;
import com.medron.starbucks.service.CustomerService;
import com.medron.starbucks.service.dto.abstracts.CustomerRequest;
import com.medron.starbucks.service.dto.request.CustomerCreateRequest;
import com.medron.starbucks.service.dto.request.CustomerUpdateRequest;
import com.medron.starbucks.service.dto.response.CustomerGetAllResponse;
import com.medron.starbucks.service.dto.response.CustomerGetResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository repository;
    private final MernisService mernisService;
    private final ModelMapper mapper;

    public Customer requestToEntity(CustomerRequest customerRequest){
        return mapper.map(customerRequest,Customer.class);
    }
    public CustomerGetResponse entityToGetResponse(Customer customer){
        return mapper.map(customer,CustomerGetResponse.class);
    }
    public CustomerGetAllResponse entityToGetAllResponse(Customer customer){
        return mapper.map(customer,CustomerGetAllResponse.class);
    }

    @Override
    public void add(CustomerCreateRequest request) {
        mernisService.checkIdentity(request);
        Customer customer = requestToEntity(request);
        customer.setId(0L);
        repository.save(customer);

    }

    @Override
    public CustomerGetResponse getById(Long id) {
        checkIfExist(id);
        return entityToGetResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public List<CustomerGetAllResponse> getAll() {
        return repository.findAll().stream().map(this::entityToGetAllResponse).toList();
    }

    @Override
    public void delete(Long id) {
        checkIfExist(id);
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, CustomerUpdateRequest request) {
        checkIfExist(id);
        Customer customer = requestToEntity(request);
        customer.setId(id);
        repository.save(customer);
    }
    public void checkIfExist(Long id){
        if(repository.findById(id).isEmpty()){
            throw new ResourceNotFoundException("Customer",id);
        }
    }

}
