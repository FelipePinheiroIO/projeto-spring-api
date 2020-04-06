package br.com.mensageriaRest.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mensageriaRest.domain.entities.Agendamento;
import br.com.mensageriaRest.domain.interfaces.repositories.IAgendamentoRepository;
import br.com.mensageriaRest.domain.interfaces.services.IAgendamentoService;

@Service
public class AgendamentoService implements IAgendamentoService {

	@Autowired
	private IAgendamentoRepository agendamentoRepository;

	@Override
	public void adicionar(Agendamento agendamento) {
		agendamentoRepository.save(agendamento);	
	}

	@Override
	public void editar(Agendamento agendamento) {
		agendamentoRepository.save(agendamento);		
	}

	@Override
	public void remover(Integer id) {
		agendamentoRepository.deleteById(id);	
	}

	@Override
	public Agendamento obterUm(Integer id) {
		Optional<Agendamento> optinalAgendamento =  agendamentoRepository.findById(id);
		Agendamento agendamento = optinalAgendamento.get();
		return agendamento;
	}
	
	@Override
	public List<Agendamento> obterTodos() {
		return (List<Agendamento>) agendamentoRepository.findAll();
	}
}
