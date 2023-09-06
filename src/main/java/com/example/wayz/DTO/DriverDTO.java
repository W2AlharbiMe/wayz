package com.example.wayz.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {

    @NotEmpty(message = "the username field is required.")
    @Column(nullable = false, unique = true)
    private String username;


    @NotEmpty(message = "the password field is required.")
    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(255) not null default 'pending'")
    private String status;

    @Column(columnDefinition = "varchar(255) unique not null")
    private String driverLicenceImgPath;

    @Column(columnDefinition = "varchar(255) unique not null")
    private String carRegistrationImgPath;

    @Column(columnDefinition = "varchar(255) unique not null")
    private String driverImgPath;

    @Column(columnDefinition = "varchar(255) unique not null")
    private String govIdImgPath;
}
