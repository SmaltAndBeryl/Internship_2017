package com.skill.India.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SessionManagementDto  implements UserDetails{

	private String userName;
	private String password;
	private String userRole;
	private Collection<SimpleGrantedAuthority> authorities;	
	
	/**
	 * @param userId
	 * @param password
	 * @param authorities
	 */
	public SessionManagementDto(String userId, String password,
			Collection<SimpleGrantedAuthority> authorities) {
		super();
		this.userName = userId;
		this.password = password;
		this.authorities = authorities;
	}
	/**
	 * @param userId
	 * @param password
	 * @param userRole
	 */
	public SessionManagementDto(String userId, String password, String userRole) {
		super();
		this.userName = userId;
		this.password = password;
		this.userRole = userRole;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
	
	
	
}
