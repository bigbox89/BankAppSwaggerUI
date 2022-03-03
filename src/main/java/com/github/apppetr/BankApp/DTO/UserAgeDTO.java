package com.github.apppetr.BankApp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.apppetr.BankApp.model.Views;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class UserAgeDTO extends UserBase {
    @Min(value = 18, message = "age should be greater than 18")
    @JsonView(Views.UpdateAge.class)
    private int age;
}
