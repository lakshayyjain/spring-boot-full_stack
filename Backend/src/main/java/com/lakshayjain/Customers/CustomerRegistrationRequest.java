package com.lakshayjain.Customers;

public record CustomerRegistrationRequest (
        String name,
        int age,
        String email,
        String password,
        Gender gender
){
}
