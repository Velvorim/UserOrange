package com.userOrange.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "vehicles")
public class Vehicle{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false, unique = true)
	private Long Id;
	
    @NotNull(message = "A Marca não pode ser nula")
    @NotEmpty(message = "A Marca não pode estar vazia")
	@Column(name = "marca", nullable = false)
	private String Marca;

    @NotNull(message = "O Modelo não pode ser nulo")
    @NotEmpty(message = "O Modelo  não pode estar vazio")
	@Column(name = "modelo", nullable = false)
	private String Modelo;
	
    @NotNull(message = "O Ano não pode ser nulo")
    @NotEmpty(message = "O Ano não pode estar vazio")
	@Column(name = "ano", nullable = false)
	private String Ano;
	
    @Column(name = "valor", nullable = false)
    private String Valor;



    @ManyToOne
	@JsonBackReference
	@JoinColumn(name="user_cpf")
	private User user;

	public Vehicle(){

	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public String getAno() {
		return Ano;
	}

	public void setAno(String ano) {
		Ano = ano;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

	@Transient
    private String rodizio;

    @Transient
    private boolean rodizioAtivo;

    public String getRodizio() {
        char ultimoDigito = this.Ano.charAt(this.Ano.length() - 1);
        if (ultimoDigito == '0' || ultimoDigito == '1') {
            this.rodizio = "Segunda-Feira";
        } else if (ultimoDigito == '2' || ultimoDigito == '3') {
            this.rodizio = "Terça-Feira";
        } else if (ultimoDigito == '4' || ultimoDigito == '5') {
            this.rodizio = "Quarta-Feira";
        } else if (ultimoDigito == '6' || ultimoDigito == '7') {
            this.rodizio = "Quinta-Feira";
        } else if (ultimoDigito == '8' || ultimoDigito == '9') {
            this.rodizio = "Sexta-Feira";
        }

        return this.rodizio;
    }

    public Boolean getRodizioAtivo() {
        char lastDigit = this.Ano.charAt(this.Ano.length() - 1);
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);

        switch (dia) {
            case Calendar.MONDAY:
                if (lastDigit == '0' || lastDigit == '1') {
                    this.rodizioAtivo = true;
                }
                break;
            case Calendar.TUESDAY:
                if (lastDigit == '2' || lastDigit == '3') {
                    this.rodizioAtivo = true;
                }
                break;
            case Calendar.WEDNESDAY:
                if (lastDigit == '4' || lastDigit == '5') {
                    this.rodizioAtivo = true;
                }
                break;
            case Calendar.THURSDAY:
                if (lastDigit == '6' || lastDigit == '7') {
                    this.rodizioAtivo = true;
                }
                break;
            case Calendar.FRIDAY:
                if (lastDigit == '8' || lastDigit == '9') {
                    this.rodizioAtivo = true;
                }
                break;
            default:
                this.rodizioAtivo = false;
        }
    
        return this.rodizioAtivo;

    }
}
