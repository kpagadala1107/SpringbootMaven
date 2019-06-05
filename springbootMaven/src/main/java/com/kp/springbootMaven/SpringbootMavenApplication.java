package com.kp.springbootMaven;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kp.springbootMaven.model.User;
import com.kp.springbootMaven.repository.UserRepository;


@SpringBootApplication
public class SpringbootMavenApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMavenApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception{
		
		userRepository.deleteAll();
		
		User kp = userRepository.save(new User("kiran", "pagadala"));
		User np = userRepository.save(new User("Nikhil", "pagadala"));
		
		System.out.println("KP : " + kp);
		System.out.println("NP : " + np);
		
		for(User user: userRepository.findAll()) {
			System.out.println("User : " + user);
		}
		
		
				
		System.out.println("User :" + userRepository.findByFirstName("kiran"));
		
		
		for(User user: userRepository.findByLastName("pagadala")) {
			System.out.println("User List :" + user);
		}

		
	
		
		
		
		
	}
	
}
