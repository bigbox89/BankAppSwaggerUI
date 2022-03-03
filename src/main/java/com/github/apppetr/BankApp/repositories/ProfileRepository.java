package com.github.apppetr.BankApp.repositories;

import com.github.apppetr.BankApp.model.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository  extends CrudRepository<Profile, Integer> {
}
