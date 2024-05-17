package com.nss.bank.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nss_customer")
public class Customer implements UserDetails {

    @Id
    @Getter
    @Column(name = "customerid", length = 10, nullable = false)
    private String customerId;

    @Getter
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Getter
    @Setter
    @Column(name = "street", length = 20, nullable = false)
    private String street;

    @Getter
    @Setter
    @Column(name = "city", length = 20, nullable = false)
    private String city;

    @Getter
    @Setter
    @Column(name = "state", nullable = false)
    private String state;

    @Getter
    @Setter
    @Column(name = "zipcode", nullable = false)
    private int zipCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return customerId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
