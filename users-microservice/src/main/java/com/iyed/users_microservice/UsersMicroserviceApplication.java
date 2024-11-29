package com.iyed.users_microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.iyed.users_microservice.service.UserService;



@SpringBootApplication
@EnableDiscoveryClient
public class UsersMicroserviceApplication {

	@Autowired
	UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}
	


	/*@PostConstruct
	void init_users() {
		// Ajouter les roles
			userService.addRole(new Role(null,"ADMIN"));
			userService.addRole(new Role(null,"USER"));
		// ajouter les utilisateurs
			userService.saveUser(new User(null,"admin","123",true,null));
			userService.saveUser(new User(null,"Iyed","123",true,null));
			userService.saveUser(new User(null,"Maryem","123",true,null));
		// ajouter les rôles aux utilisateurs
			userService.addRoleToUser("admin","ADMIN");
			userService.addRoleToUser("admin","USER");
			userService.addRoleToUser("Iyed","USER");
			userService.addRoleToUser("Maryem","USER");
	}
	*/
	
}
