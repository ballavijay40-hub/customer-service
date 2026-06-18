package com.banking.microservice.customerservice.mapper;

import com.banking.microservice.customerservice.dto.CustomerRequestDto;
import com.banking.microservice.customerservice.dto.CustomerRequestDto;
import com.banking.microservice.customerservice.dto.CustomerResponseDto;
import com.banking.microservice.customerservice.entity.Customer;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class CustomerMapper {
   public Customer toEntity(CustomerRequestDto req){
       return Customer.builder()
               .fullname(req.getFullname())
               .email(req.getEmail())
               .phone(req.getPhone())
               .address(req.getAddress())
               .kycNumber(req.getKycNumber())
               .createdAt(LocalDateTime.now())
               .build();

   }
   public CustomerResponseDto toResponse(Customer customer){
       return CustomerResponseDto.builder()
               .id(customer.getId())
               .fullname(customer.getFullname())
               .email(customer.getEmail())
               .phone(customer.getPhone())
               .address(customer.getAddress())
               .kyc(customer.getKycNumber())
               .build();
   }
}
