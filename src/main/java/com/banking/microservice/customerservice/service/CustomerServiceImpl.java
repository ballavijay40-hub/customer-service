package com.banking.microservice.customerservice.service;

import com.banking.microservice.customerservice.dto.CustomerRequestDto;
import com.banking.microservice.customerservice.dto.CustomerResponseDto;
import com.banking.microservice.customerservice.entity.Customer;
import com.banking.microservice.customerservice.mapper.CustomerMapper;
import com.banking.microservice.customerservice.repository.CustomerRepository;
import com.banking.microservice.customerservice.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto dto){
        Customer customer=customerMapper.toEntity(dto);
        customerRepository.save(customer);
        return customerMapper.toResponse(customer);

    }

    @Override
    public List<CustomerResponseDto> getAllCustomers(){

        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .toList();

    }
    @Override
    public CustomerResponseDto getById(Long id){
        Customer customer=customerRepository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException("customer not found."));
        return customerMapper.toResponse(customer);
    }

    @Override
    public void deleteById(Long id){
        Customer customer=customerRepository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException("customer not found."));

        customerRepository.deleteById(id);

    }

}
