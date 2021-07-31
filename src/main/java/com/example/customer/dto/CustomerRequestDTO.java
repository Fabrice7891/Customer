package com.example.customer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data @AllArgsConstructor @NoArgsConstructor
public class CustomerRequestDTO {
    @JsonIgnore
    private  String id;
    @NotNull
    private String name;
    @Email
    private String email;
}
