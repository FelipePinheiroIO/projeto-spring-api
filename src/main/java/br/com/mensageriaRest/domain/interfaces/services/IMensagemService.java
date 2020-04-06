package br.com.mensageriaRest.domain.interfaces.services;

import java.util.List;

import br.com.mensageriaRest.domain.entities.Mensagem;

public interface IMensagemService{
	
	void adicionar(Mensagem mensagem);
	void editar(Mensagem mensagem);
	void remover(Integer id);
	Mensagem obterUm(Integer id);
	List<Mensagem> obterTodos();
}
