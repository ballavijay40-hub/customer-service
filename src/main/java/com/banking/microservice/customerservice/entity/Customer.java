package com.banking.microservice.customerservice.entity;




import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Table(name="customers",
        uniqueConstraints = @UniqueConstraint(columnNames = {"email","phone","kycNumber"})
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

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false )
    private  String kycNumber;


    private LocalDateTime createdAt;

    private LocalDateTime uodatedAt;



}
