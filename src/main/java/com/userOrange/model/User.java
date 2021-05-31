package com.userOrange.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "users")
public class User {


	@Id
    @NotNull(message = "O Cpf não pode ser nulo")
    @NotEmpty(message = "O Cpf não pode estar vazio")
	@Column(name = "cpf", nullable = false, unique = true)
	private String cpf;

	
	@NotNull(message = "O Email não pode ser nulo")
    @NotEmpty(message = "O Email não pode estar vazio")
	@Column(name = "email", nullable = false)
	private String email;


	@NotNull(message = "O Nome não pode ser nulo")
    @NotEmpty(message = "O Nome não pode estar vazio")
	@Column(name = "nome", nullable = false)
	private String nome;
	
	
	@NotNull(message = "A Data de Nascimento não pode ser nula")
	@Column(name = "dataNasc", nullable = false)
	private Date dataNasc;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
		CascadeType.REMOVE })
	@JsonManagedReference
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	public User(){

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String Cpf) {
		cpf = Cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String Email) {
		email = Email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String Nome) {
		nome = Nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date DataNasc) {
		dataNasc = DataNasc;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicle) {
		vehicles = vehicle;
	}

}
