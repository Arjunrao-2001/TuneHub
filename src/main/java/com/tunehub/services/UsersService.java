package com.tunehub.services;

import com.tunehub.entities.Users;

public interface UsersService {
	public String addUsers(Users users);
	
	public boolean emailExists(String email);
	
	public boolean validateUser(String email, String password);

	public String getRole(String email);
	
	public Users getUser(String email);
	
	public void updateUsers(Users users);
}
