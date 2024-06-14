//package com.green.restServer.dto;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.green.restServer.entity.User;
//
//public class CustomUserDetails implements UserDetails{
//
//	private User user; 
//	
//	public CustomUserDetails(User user) {
//		this.user = user;
//	}
//	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//
//		Collection<GrantedAuthority> collection = new ArrayList<>();
//		collection.add(new GrantedAuthority() {
//
//			@Override
//			public String getAuthority() {
//				return user.getRole();
//			}
//		});
//		
//		return collection;
//	}
//
//	@Override
//	public String getPassword() {
//		
//		return user.getPassword();
//	}
//
//	@Override
//	public String getUsername() {
//		
//		return user.getUsername();
//	}
//	
//	public String getRole() {
//		
//		return user.getRole();
//	}
//	
//	public String getUname() {
//		
//		return user.getUname();
//	}
//	
//	public LocalDate getBirthDate() {
//		
//		return user.getBirthDate();
//	}
//	
//	public String getGender() {
//		
//		return user.getGender();
//	}
//	
//	public String getEmail() {
//		
//		return user.getEmail();
//	}
//	
//	public String getTel() {
//		
//		return user.getTel(); 
//	}
//	
//	public String getUaddr() {
//		
//		return user.getUaddr();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}
