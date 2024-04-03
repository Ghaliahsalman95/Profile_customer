package com.example.relationonetoone.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data@AllArgsConstructor
public class ProfileDTO {
    @NotNull
    private Integer customer_id;
    @NotEmpty
    private String email;
    @NotEmpty
    private String phone;
    @NotNull
    @Min(20)
    private Integer age;//add all, but @column noo anything of database not use here
}
