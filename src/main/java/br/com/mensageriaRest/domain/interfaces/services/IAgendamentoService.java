package br.com.mensageriaRest.domain.interfaces.services;

import java.util.List;

import br.com.mensageriaRest.domain.entities.Agendamento;

public interface IAgendamentoService{
	
	void adicionar(Agendamento agendamento);
	void editar(Agendamento agendamento);
	void remover(Integer id);
	Agendamento obterUm(Integer id);
	List<Agendamento> obterTodos();
}
