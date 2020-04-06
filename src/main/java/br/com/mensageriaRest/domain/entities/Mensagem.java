package br.com.mensageriaRest.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="TMensagem")
@Inheritance(strategy= InheritanceType.JOINED)
@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.PROPERTY, property= "type")
@JsonSubTypes({
	@JsonSubTypes.Type(value= Email.class, name="Email"),
	@JsonSubTypes.Type(value= Sms.class, name="Sms"),
	@JsonSubTypes.Type(value= Notificacao.class, name="Notificacao"),
})
@JsonIdentityInfo(scope=Mensagem.class, property="id", generator=ObjectIdGenerators.PropertyGenerator.class)
public abstract class Mensagem {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String destinatario;
	private String mensagem;
	@ManyToOne
	@JoinColumn(name="idAgendamento")
	private Agendamento agendamento;
	
	public Mensagem() {}
	
	public Mensagem(String destinatario, String mensagem, Agendamento agendamento)
	{
		this();
		this.setMensagem(mensagem);
		this.setDestinatario(destinatario);
		this.setAgendamento(agendamento);
	}
	
	@Override
	public String toString()
	{
		return String.format("%d - %s - %s",this.getId(), this.getDestinatario(), this.getMensagem());
	}
	
	public void setId(Integer id)
	{
		this.id= id;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setMensagem(String mensagem)
	{
		this.mensagem= mensagem;
	}
	
	public String getMensagem()
	{
		return mensagem;
	}
	
	public void setDestinatario(String destinatario)
	{
		this.destinatario= destinatario;
	}
	
	public String getDestinatario()
	{
		return destinatario;
	}
	
	public void setAgendamento(Agendamento agendamento)
	{
		this.agendamento= agendamento;
	}
	
	public Agendamento getAgendamento()
	{
		return agendamento;
	}
}
