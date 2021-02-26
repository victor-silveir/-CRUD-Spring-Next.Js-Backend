package com.example.crud.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.crud.enums.Roles;

public class UserSecurity implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String userName;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSecurity() {
	}
	
	
	public UserSecurity(Integer id, String userName, String password,
			Set<Roles> roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.authorities = roles.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}



	public Integer getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
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
