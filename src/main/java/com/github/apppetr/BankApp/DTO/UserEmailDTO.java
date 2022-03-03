package com.github.apppetr.BankApp.DTO;


import com.fasterxml.jackson.annotation.JsonView;
import com.github.apppetr.BankApp.model.Views;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserEmailDTO extends UserBase {
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    @JsonView(Views.Email.class)
    private String email;
}
