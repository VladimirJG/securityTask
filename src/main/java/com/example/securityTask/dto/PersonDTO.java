package com.example.securityTask.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PersonDTO {
    @NotEmpty(message = "name must not be empty")
    @Size(min = 2, max = 100, message = "names size min=2, max=100")
    private String username;
    private int yearOfBirth;
    private String password;
}
