package br.com.mensageriaRest.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mensageriaRest.domain.entities.Remetente;
import br.com.mensageriaRest.domain.interfaces.repositories.IRemetenteRepository;
import br.com.mensageriaRest.domain.interfaces.services.IRemetenteService;

@Service
public class RemetenteService implements IRemetenteService {

	@Autowired
	private IRemetenteRepository remetenteRepository;

	@Override
	public void adicionar(Remetente remetente) {
		remetenteRepository.save(remetente);	
	}

	@Override
	public void editar(Remetente remetente) {
		remetenteRepository.save(remetente);		
	}

	@Override
	public void remover(Integer id) {
		remetenteRepository.deleteById(id);	
	}

	@Override
	public Remetente obterUm(Integer id) {
		Optional<Remetente> optinalRemetente =  remetenteRepository.findById(id);
		Remetente remetente = optinalRemetente.get();
		return remetente;
	}
	
	@Override
	public List<Remetente> obterTodos() {
		return (List<Remetente>) remetenteRepository.findAll();
	}
}
