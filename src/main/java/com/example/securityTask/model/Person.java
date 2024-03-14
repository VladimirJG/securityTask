package com.example.securityTask.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotEmpty(message = "name must not be empty")
    @Size(min = 2,max = 100,message = "names size min=2, max=100")
    @Column(name = "username")
    private String username;
    @Column(name = "year_of_birth")
    private int yearOfBirth;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
}
