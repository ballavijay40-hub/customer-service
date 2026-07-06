package com.banking.microservice.customerservice.controller;


import com.banking.microservice.customerservice.dto.CustomerRequestDto;
import com.banking.microservice.customerservice.dto.CustomerResponseDto;
import com.banking.microservice.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    public ResponseEntity<CustomerResponseDto> createCustomer(@Valid @RequestBody CustomerRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(dto));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomer(){
        return  ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable String customerId){
        return ResponseEntity.ok(customerService.getBycustomerId(customerId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable String customerId,@RequestBody CustomerRequestDto dto){
        return ResponseEntity.ok(customerService.updateByCustomerId(customerId,dto));

    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String customerId){
        customerService.deleteByCustomerId(customerId);
        return ResponseEntity.noContent().build();
    }

}
