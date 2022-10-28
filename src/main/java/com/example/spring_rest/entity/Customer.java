package com.example.spring_rest.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private Long phoneNo;
    private String name;
    private Integer age;
    private String gender;
    private String address;
    private Integer planId;
}
