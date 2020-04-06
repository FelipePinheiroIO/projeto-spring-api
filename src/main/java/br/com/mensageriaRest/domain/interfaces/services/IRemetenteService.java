package br.com.mensageriaRest.domain.interfaces.services;

import java.util.List;

import br.com.mensageriaRest.domain.entities.Remetente;

public interface IRemetenteService{
	
	void adicionar(Remetente remetente);
	void editar(Remetente remetente);
	void remover(Integer id);
	Remetente obterUm(Integer id);
	List<Remetente> obterTodos();
}
