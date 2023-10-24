package com.oati.tecnologo.usermicroservice.adapters.driven.jpa.mysql.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


public class PrincipalUser implements UserDetails {
    private String name;
    private String numberDocument;
    private  long id;


    private Collection<? extends GrantedAuthority> authorities;

    public PrincipalUser(String name, String numberDocument,
                         Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.numberDocument = numberDocument;
        this.authorities = authorities;
        this.id = id;
    }

    public static PrincipalUser build(UserEntity usuario, List<RoleEntity> roles) {
            List<SimpleGrantedAuthority> authorities = roles.stream()
                    .map(rol -> new SimpleGrantedAuthority(rol.getName())).toList();
        return new PrincipalUser(usuario.getName(), usuario.getNumberDocument(),authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return numberDocument;
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

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

}
