package com.github.apppetr.BankApp.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.apppetr.BankApp.model.Profile;
import com.github.apppetr.BankApp.model.Views;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class ProfileDTO extends UserBase {
    @Min(value = 10)
    @JsonView(Views.Create.class)
    @Column(name = "cash")
    private float cash;

        public ProfileDTO(float cash) {
        this.cash = cash;
    }

    public Profile toProfile() {
        var p = new Profile();
        p.setCash(cash);
        return p;
    }
}
