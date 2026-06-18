package com.banking.microservice.customerservice.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponseDto {

    private Long id;
    private String fullname;
    private String email;
    private String phone;
    private String address;
    private String kyc;

}
