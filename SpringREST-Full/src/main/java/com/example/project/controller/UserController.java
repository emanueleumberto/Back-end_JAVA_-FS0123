package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.User;
import com.example.project.service.UserService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@OpenAPIDefinition(
        info = @Info(
                 title = "API personas", 
                 description = "Este es un ejemplo de servidor Personas-Server."
            + "Usted puyede encontrar mas acerca de Swagger " + "[http://swagger.io](http://swagger.io) o en "
            + "[irc.freenode.net, #swagger](http://swagger.io/irc/).",
            termsOfService = "http://swagger.io/terms/", 
              license = @License(
                          name = "Apache 2.0", 
                          url = "http://springdoc.org"), 
       version = "otra"
    ))
    @Tag(name = "persona", description = "API para personas")
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		//return userService.getAll(); -> solo il body della risposta
		//return new ResponseEntity(userService.getAll(), HttpStatus.OK); -> il body e lo status code della risposta 
		return ResponseEntity.ok(userService.getAll()); // Metodo alternativo -> il body e lo status code della risposta
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<User>> getPageableAllUser(Pageable pageable) {
		//http://localhost:8080/api/users/page?size=2&page=2&sort=name,ASC
		return ResponseEntity.ok(userService.getPageableAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		return ResponseEntity.ok(userService.getById(id));
//		try {
//			return ResponseEntity.ok(userService.getById(id));
//		} catch (EntityExistsException e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user) {
		return ResponseEntity.ok(userService.create(user));
//		try {
//			return ResponseEntity.ok(userService.create(user));
//		} catch (EntityNotFoundException e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
//		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long id) {
		return ResponseEntity.ok(userService.update(user, id));
//		try {
//			return ResponseEntity.ok(userService.update(user, id));
//		} catch (EntityExistsException e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		return ResponseEntity.ok(userService.remove(id));
//		try {
//			return ResponseEntity.ok(userService.remove(id));
//		} catch (EntityExistsException e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
	}
}
