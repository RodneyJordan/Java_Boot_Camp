package com.codington.festival.Models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class UserWithRoles extends User implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserWithRoles(User copy) {
        super(copy);  // Call the copy constructor defined in User
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
}