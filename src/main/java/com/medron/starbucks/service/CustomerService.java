package com.medron.starbucks.service;

import com.medron.starbucks.service.dto.request.CustomerCreateRequest;
import com.medron.starbucks.service.dto.request.CustomerUpdateRequest;
import com.medron.starbucks.service.dto.response.CustomerGetAllResponse;
import com.medron.starbucks.service.dto.response.CustomerGetResponse;

import java.util.List;

public interface CustomerService {
    void add(CustomerCreateRequest request);
    CustomerGetResponse getById(Long id);
    List<CustomerGetAllResponse> getAll();
    void delete(Long id);
    void update(Long id, CustomerUpdateRequest request);
}
