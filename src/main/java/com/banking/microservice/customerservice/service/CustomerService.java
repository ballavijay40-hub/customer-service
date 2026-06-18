package com.banking.microservice.customerservice.service;

import com.banking.microservice.customerservice.dto.CustomerRequestDto;
import com.banking.microservice.customerservice.dto.CustomerResponseDto;
import java.util.List;


public interface CustomerService {

    CustomerResponseDto createCustomer(CustomerRequestDto dto);

    List<CustomerResponseDto> getAllCustomers();

    CustomerResponseDto getById(Long id);

    CustomerResponseDto updateCustomerById(Long id,CustomerRequestDto dto);


    void deleteById(Long id);
}
