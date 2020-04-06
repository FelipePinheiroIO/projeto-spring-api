package br.com.mensageriaRest.domain.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TNotificacao")
@PrimaryKeyJoinColumn(name= "idMensagem")
public class Notificacao extends Mensagem {
		
	public Notificacao() {}
	
	public Notificacao(String destinatario, String mensagem, Agendamento agendamento)
	{
		super(destinatario, mensagem, agendamento);
	}
}
