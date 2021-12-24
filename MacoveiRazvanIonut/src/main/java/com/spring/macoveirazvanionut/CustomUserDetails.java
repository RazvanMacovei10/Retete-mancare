package com.spring.macoveirazvanionut;

import com.spring.macoveirazvanionut.entities.Recipe;
import com.spring.macoveirazvanionut.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {


    private User user;

    public User getUser() {
        return user;
    }


    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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

    public String getFullName(){
        return user.getFirstName()+" "+user.getLastName();
    }

    public Integer getId(){
        return user.getId();
    }

    public List<Recipe> getRecipes(){
        return (List<Recipe>) user.getRecipes();
    }
}
