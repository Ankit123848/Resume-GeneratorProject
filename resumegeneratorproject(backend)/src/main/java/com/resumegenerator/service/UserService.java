package com.resumegenerator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resumegenerator.model.User;
import com.resumegenerator.repository.UserRepository;

import org.springframework.stereotype.Repository;


@Service
@Transactional
public class UserService 
{
	@Autowired
	private UserRepository repo;
	
	public List<User> listAll() {
        return repo.findAll();
    }
	
	public User saveUser(User user)
	{
		return repo.save(user);
	}
	
	public User findUserByEmail(String email)
	{
		return findUserByEmail(email);
	}
	public User findUserByEmailAndPassword(String email, String password)
	{
		return findUserByEmailAndPassword(email, password);
	}
}
