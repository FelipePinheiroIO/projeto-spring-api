package br.com.mensageriaRest.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mensageriaRest.domain.entities.Mensagem;
import br.com.mensageriaRest.domain.interfaces.repositories.IMensagemRepository;
import br.com.mensageriaRest.domain.interfaces.services.IMensagemService;

@Service
public class MensagemService implements IMensagemService {

	@Autowired
	private IMensagemRepository mensagemRepository;

	@Override
	public void adicionar(Mensagem mensagem) {
		mensagemRepository.save(mensagem);	
	}

	@Override
	public void editar(Mensagem mensagem) {
		mensagemRepository.save(mensagem);		
	}

	@Override
	public void remover(Integer id) {
		mensagemRepository.deleteById(id);	
	}

	@Override
	public Mensagem obterUm(Integer id) {
		Optional<Mensagem> optinalMensagem =  mensagemRepository.findById(id);
		Mensagem mensagem = optinalMensagem.get();
		return mensagem;
	}
	
	@Override
	public List<Mensagem> obterTodos() {
		return (List<Mensagem>) mensagemRepository.findAll();
	}
}
