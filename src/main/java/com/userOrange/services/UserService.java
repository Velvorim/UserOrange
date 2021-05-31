package com.userOrange.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userOrange.model.User;
import com.userOrange.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User ListUsers(String Cpf) {
		Optional<User> user = userRepo.findByCpf(Cpf);
		return user.orElseThrow(() -> new com.userOrange.error.ObejctNotFoundExecption(
				"Usuário não encontrado! Cpf: " + Cpf+ ", Tipo "+ User.class.getName()) );
	}

	public User insert(User user) throws Exception {
		Optional<User> existingUser = userRepo.findByCpf(user.getCpf());
		Optional<User> existingEmail = userRepo.findByEmail(user.getEmail());

		if (existingUser.isPresent()) {
            throw new Exception("Cpf já está cadastrado");
        } else if (existingEmail.isPresent()){
            throw new Exception("Email já está cadastrado.");
        } else{
            return userRepo.save(user);

        }

	}

}
