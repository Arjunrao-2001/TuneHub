package com.tunehub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entities.Users;
import com.tunehub.repositories.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService {

	@Autowired
	UsersRepository repo;
	
	@Override
	public String addUsers(Users users) {
		repo.save(users);
		return "User Added Successfully";
	}

	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users users = repo.findByEmail(email);
		String db_pass=users.getPassword();
		if(password.equals(db_pass))
		{
			return true;
		}
		else
		{
		return false;
		}
	}

	@Override
	public String getRole(String email) {
		Users users = repo.findByEmail(email);
		return users.getRole();
	}

	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void updateUsers(Users users) {
		repo.save(users);
	}

}
