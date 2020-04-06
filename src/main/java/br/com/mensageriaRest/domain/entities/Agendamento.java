package br.com.mensageriaRest.domain.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="TAgendamento")
@JsonIdentityInfo(scope=Agendamento.class, property="id", generator=ObjectIdGenerators.PropertyGenerator.class)
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private String prioridade;
	private String dataHoraEnvio;
	@OneToOne(fetch= FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name= "idRemetente")
	Remetente remetente;
	@OneToMany(
			mappedBy= "agendamento",
			fetch = FetchType.EAGER, 
			cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Mensagem> mensagens;
	
	public Agendamento() {}
	
	public Agendamento(String descricao, String prioridade, String dataHoraEnvio, Remetente remetente)
	{
		this();
		this.setDescricao(descricao);
		this.setDataHoraEnvio(dataHoraEnvio);
		this.setRemetente(remetente);
	}
	
	@Override
	public String toString()
	{
		return String.format("%d - %s - %s - %s",this.getId(), this.getDescricao(), this.getPrioridade(), this.getDataHoraEnvio());
	}
	
	public void setId(Integer id)
	{
		this.id= id;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setDescricao(String descricao)
	{
		this.descricao= descricao;
	}
	
	public String getDescricao()
	{
		return descricao;
	}
	
	public void setPrioridade(String prioridade)
	{
		this.prioridade= prioridade;
	}
	
	public String getPrioridade()
	{
		return prioridade;
	}
	
	public void setDataHoraEnvio(String dataHoraEnvio)
	{
		this.dataHoraEnvio= dataHoraEnvio;
	}
	
	public String getDataHoraEnvio()
	{
		return dataHoraEnvio;
	}
	
	public void setRemetente(Remetente remetente)
	{
		this.remetente= remetente;
	}
	
	public Remetente getRemetente()
	{
		return remetente;
	}
	
	public void setMensagens(List<Mensagem> mensagens)
	{
		this.mensagens= mensagens;
	}
	
	public List<Mensagem> getMensagens()
	{
		return mensagens;
	}
}
