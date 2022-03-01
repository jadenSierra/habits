package com.codingdojo.habits.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.habits.models.LoginUser;
import com.codingdojo.habits.models.User;
import com.codingdojo.habits.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
    	
//    	if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
//    		result.rejectValue("email", "Unique" , "This email is already taken");
//    	}
        Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
        
        if(potentialUser.isPresent()) {
        	result.rejectValue("email", "Unique" , "This email is already taken");
        }
        
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "Passwords do not match");
    	}
    	
    	if(result.hasErrors()) {
    		return null;
    	} else {
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashed);
    		return userRepo.save(newUser);
    	}
    }
    
    
    public User login(LoginUser newLoginObject, BindingResult result) {
    	
        if(result.hasErrors()) {
        	return null;
        }
        
        Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
        if(!potentialUser.isPresent()) {
        	result.rejectValue("email", "Unique", "Email not found");
        	return null;
        }
        
        User user = potentialUser.get();
        
        if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())){
        	result.rejectValue("password", "Matches", "invalid password");
        }
        
        if(result.hasErrors()) {
        	return null;
        } else {
        	return user;
        }
    }
    
    public User findOne(Long id) {
    	Optional<User> optionalUser = userRepo.findById(id);
    	if(optionalUser.isPresent()) {
    		return optionalUser.get();
    	} else {
    		return null;
    	}
    }
}