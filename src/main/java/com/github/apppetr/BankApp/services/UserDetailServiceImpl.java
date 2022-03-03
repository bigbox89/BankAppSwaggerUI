package com.github.apppetr.BankApp.services;

import com.github.apppetr.BankApp.model.Role;
import com.github.apppetr.BankApp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        var userByName = userRepository.findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User Not Found with username: " + name));

        return new User(userByName.getName(), userByName.getPassword(),
                mapRolesToAuthorities(userByName.getRole()));
    }
    private Collection<GrantedAuthority> mapRolesToAuthorities(Role role) {
        List<Role> collections = new ArrayList<>();
        collections.add(role);
        return collections.stream().map(r -> new SimpleGrantedAuthority(
                r.getName())).collect(Collectors.toList());
    }
}
