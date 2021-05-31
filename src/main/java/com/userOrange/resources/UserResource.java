package com.userOrange.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.userOrange.error.ObejctNotFoundExecption;
import com.userOrange.model.User;

import com.userOrange.services.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
	private UserService uVService;

	
	
	@GetMapping(value = "/{cpf}")
	public ResponseEntity<?> list(@Valid @PathVariable("cpf") String cpf) {

		User users = uVService.ListUsers(cpf);
		return ResponseEntity.ok().body(users);
		
	}

    @PostMapping(consumes = "application/json")
    public ResponseEntity<User> addUsuarios(@Valid @RequestBody User users) throws Exception{
     
      try {
        User user = uVService.insert(users);
         
        return new ResponseEntity<>(user, HttpStatus.CREATED);

      } catch (Exception e) {
        
        throw new ObejctNotFoundExecption(e.getMessage());
        
      }
      
    }
}
