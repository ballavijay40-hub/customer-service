package com.banking.microservice.customerservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDto {

    @NotNull(message = "name is required.")
    private String fullname;



    @Email
    @NotNull(message = "email is required.")
    private String email;
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Phone number must be 10 digits."
    )
    private String phone;


    private String address;

    private String kycNumber;


}
