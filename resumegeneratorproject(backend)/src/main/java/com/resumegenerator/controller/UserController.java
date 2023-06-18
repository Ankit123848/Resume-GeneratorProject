package com.resumegenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resumegenerator.model.User;
import com.resumegenerator.service.UserService;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
public class UserController 
{
	@Autowired
	private UserService service;
	
	 @GetMapping("/signup")
	    public List<User> list() 
	    {
	        return service.listAll();
	    }
	 
	@PostMapping("/signup")
	public User add(@RequestBody User user) 
    {
       return service.saveUser(user);
    }
	
	
	public User signUp(@RequestBody User user) throws Exception
	{
		String tempEmail = user.getEmail();
		if(tempEmail != null && !"".equals(tempEmail))
		{
			User userobj = service.findUserByEmail(tempEmail);
			if(userobj != null)
			{
				throw new Exception("Email already exist!");
			}
		}
		User userObj = null;
		service.saveUser(user);
		return userObj;
	}
	
	@GetMapping("/login")
    public List<User> list1() 
    {
        return service.listAll();
    }
	
	@PostMapping("/login")
	public User save(@RequestBody User user) 
    {
       return service.saveUser(user);
    }
    @CrossOrigin("http://localhost:4200") 
	public User logIn(@RequestBody User user) throws Exception
	{
		String tempEmail = user.getEmail();
		String tempPassword = user.getPassword();
		User userObj = null;
		if(tempEmail != null && tempPassword != null)
		{
			userObj = service.findUserByEmailAndPassword(tempEmail, tempPassword);
		}
		if(userObj == null)
		{
			throw new Exception("Username doesn't exist!");
		}
		return userObj;
	}
}

