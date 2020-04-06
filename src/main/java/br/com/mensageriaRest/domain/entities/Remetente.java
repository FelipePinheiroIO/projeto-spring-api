package br.com.mensageriaRest.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="TRemetente")
@JsonIdentityInfo(scope=Remetente.class, property="id", generator=ObjectIdGenerators.PropertyGenerator.class)
public class Remetente {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String celular;
	
	public Remetente() {}
	
	public Remetente(String nome, String email, String celular)
	{	this();
		this.setNome(nome);
		this.setEmail(email);
		this.setCelular(celular);
	}
	
	@Override
	public String toString()
	{
		return String.format("%d - %s - %s - %s",this.getId(), this.getNome(), this.getEmail(), this.getCelular());
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id= id;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome= nome;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	private void setEmail(String email)
	{
		this.email= email;
	}
	
	public String getCelular()
	{
		return celular;
	}
	
	public void setCelular(String celular)
	{
		this.celular= celular;
	}
}
