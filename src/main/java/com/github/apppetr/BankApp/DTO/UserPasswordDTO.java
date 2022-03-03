package com.github.apppetr.BankApp.DTO;


import com.fasterxml.jackson.annotation.JsonView;
import com.github.apppetr.BankApp.model.Views;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserPasswordDTO extends UserBase {
    @NotEmpty(message = "Password should not be empty")
    @Size(min = 2, max = 60, message = "Password should be between 2 and 30 characters")
    @JsonView(Views.UpdatePassword.class)
    private String password;
}
