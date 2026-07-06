package com.banking.microservice.customerservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="customers",
        uniqueConstraints = @UniqueConstraint(columnNames = {"email","phone"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String customerId;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;


    private String address;


    private  String kycNumber;


    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



}
