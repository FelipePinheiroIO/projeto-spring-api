package br.com.mensageriaRest.domain.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TSms")
@PrimaryKeyJoinColumn(name= "idMensagem")
public class Sms extends Mensagem {

	public Sms() {}
	
	public Sms(String destinatario, String mensagem, Agendamento agendamento)
	{
		super(destinatario, mensagem, agendamento);
	}
}
