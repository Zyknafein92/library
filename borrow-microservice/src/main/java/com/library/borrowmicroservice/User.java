package com.library.borrowmicroservice;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String adress;
    private String postalCode;
}