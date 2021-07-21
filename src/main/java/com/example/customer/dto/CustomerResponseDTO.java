package com.example.customer.dto;

import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
//@ToString @Builder
public class CustomerResponseDTO {
    private  String id;
    private String name;
    private  String email;
}
