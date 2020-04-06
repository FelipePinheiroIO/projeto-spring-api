package br.com.mensageriaRest.domain.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TEmail")
@PrimaryKeyJoinColumn(name= "idMensagem")
public class Email extends Mensagem {

	private String emCopia;
	private String emCopiaOculta;
	
	public Email() {}
	
	public Email(String emCopia, String emCopiaOculta, String destinatario, String mensagem, Agendamento agendamento)
	{
		super(destinatario, mensagem, agendamento);
		this.setEmCopia(emCopia);
		this.setEmCopiaOculta(emCopiaOculta);
	}
	
	
	@Override
	public String toString()
	{
		return String.format("%s - %s", this.getEmCopia(), this.getEmCopiaOculta());
	}
	
	public void setEmCopia(String emCopia)
	{
		this.emCopia= emCopia;
	}
	
	public String getEmCopia()
	{
		return emCopia;
	}
	
	public void setEmCopiaOculta(String emCopiaOculta)
	{
		this.emCopiaOculta= emCopiaOculta;
	}
	
	public String getEmCopiaOculta()
	{
		return emCopiaOculta;
	}
}
