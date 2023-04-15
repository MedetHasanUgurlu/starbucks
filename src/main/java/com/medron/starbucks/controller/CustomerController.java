package com.medron.starbucks.controller;

import com.medron.starbucks.service.CustomerService;
import com.medron.starbucks.service.dto.request.CustomerCreateRequest;
import com.medron.starbucks.service.dto.request.CustomerUpdateRequest;
import com.medron.starbucks.service.dto.response.CustomerGetAllResponse;
import com.medron.starbucks.service.dto.response.CustomerGetResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    ResponseEntity<Void> createCustomer(@RequestBody  CustomerCreateRequest request){
        service.add(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity<CustomerGetResponse> getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }
    @GetMapping
    ResponseEntity<List<CustomerGetAllResponse>> getAllCustomer(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }
    @PutMapping("{id}")
    ResponseEntity<Void> updateCustomer(@PathVariable Long id,@RequestBody @Valid CustomerUpdateRequest request){
        service.update(id,request);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
