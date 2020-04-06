package br.com.mensageriaRest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mensageriaRest.domain.entities.Agendamento;
import br.com.mensageriaRest.domain.entities.Mensagem;
import br.com.mensageriaRest.domain.entities.Remetente;
import br.com.mensageriaRest.domain.interfaces.services.IAgendamentoService;
import br.com.mensageriaRest.domain.interfaces.services.IMensagemService;
import br.com.mensageriaRest.domain.interfaces.services.IRemetenteService;

@RestController
@RequestMapping("/v1/api/agendamentos")
public class AgendamentoController {
	
	@Autowired
	private IAgendamentoService agendamentoService;
	
	@Autowired
	private IRemetenteService remetenteService;
	
	@Autowired
	private IMensagemService mensagemService;
	
	@PostMapping
	public void incluir(@RequestBody Agendamento agendamento)
	{
		agendamentoService.adicionar(agendamento);
	}
	
	@PutMapping("{id}")
	public void editar(@RequestBody Agendamento agendamento, @PathVariable Integer id)
	{
		if(agendamento.getId() == id)
		{
			Agendamento agendamentoExistente= agendamentoService.obterUm(id);
			agendamentoExistente.setDescricao(agendamento.getDescricao());
			agendamentoExistente.setPrioridade(agendamento.getPrioridade());
			agendamentoExistente.setDataHoraEnvio(agendamento.getDataHoraEnvio());
			agendamentoService.editar(agendamentoExistente);
		}
	}
	
	@DeleteMapping("{id}")
	public void excluir(@PathVariable Integer id)
	{
		agendamentoService.remover(id);
	}
	
	@RequestMapping("{id}")
	public Agendamento obterUm(@PathVariable Integer id)
	{
		return agendamentoService.obterUm(id);
	}
	
	@RequestMapping
	public List<Agendamento> obterTodos()
	{
		return agendamentoService.obterTodos();
	}
	
	
	@PostMapping("{id}/remetentes")
	public void adicionarRemetente(@RequestBody Remetente remetente, @PathVariable Integer id)
	{
		Agendamento agendamento= agendamentoService.obterUm(id);
		agendamento.setRemetente(remetente);
		agendamentoService.adicionar(agendamento);
	}
	
	@PutMapping("remetentes/{id}")
	public void editarRemetente(@RequestBody Remetente remetente, @PathVariable Integer id)
	{
		if(remetente.getId() == id)
			remetenteService.editar(remetente);
	}
	
	@DeleteMapping("remetentes/{id}")
	public void removerRemetente(@PathVariable Integer id)
	{  
		Agendamento agendamento= agendamentoService.obterUm(id);
		agendamento.setRemetente(null);
		agendamentoService.adicionar(agendamento);
		remetenteService.remover(id);
	}
	
	@RequestMapping("remetentes/{id}")
	public Remetente obterUmRemetente(@PathVariable Integer id)
	{
		return remetenteService.obterUm(id);
	}
	
	@RequestMapping("{id}/remetentes")
	public List<Remetente> obterTodosRemetentes(@PathVariable Integer id)
	{
		return remetenteService.obterTodos();
	}
	
	@PostMapping("{id}/mensagens")
	public void adicionarMensagem(@RequestBody Mensagem mensagem, @PathVariable Integer id)
	{
		Agendamento agendamento= agendamentoService.obterUm(id);	
		mensagem.setAgendamento(agendamento);
	
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		mensagens.add(mensagem);

		agendamento.setMensagens(mensagens);
		
		agendamentoService.adicionar(agendamento);
	}
	
	@PutMapping("mensagens/{id}")
	public void editarMensagem(@RequestBody Mensagem mensagem, @PathVariable Integer id)
	{
		if(mensagem.getId() == id)
		{
			Mensagem mensagemExistente= mensagemService.obterUm(mensagem.getId());
			Agendamento agendamento= mensagemExistente.getAgendamento();
			mensagem.setAgendamento(agendamento);
			mensagemService.editar(mensagem);
		}
	}
	
	@DeleteMapping("mensagens/{id}")
	public void removerMensagem(@PathVariable Integer id)
	{	
		Mensagem mensagemExistente= mensagemService.obterUm(id);
		Agendamento agendamento= agendamentoService.obterUm(mensagemExistente.getAgendamento().getId());
		List<Mensagem> mensagensExistentes = agendamento.getMensagens();
		
		List<Mensagem> mensagens= new ArrayList<Mensagem>();
		for(Mensagem mensagem : mensagensExistentes)
		{
			if(mensagem.getId() != id)
			{
				mensagem.setAgendamento(agendamento);
				mensagens.add(mensagem);
			}
		}
			
		agendamentoService.remover(agendamento.getId());
		agendamento.setMensagens(mensagens);
		agendamentoService.adicionar(agendamento);
	}
	
	@RequestMapping("mensagens/{id}")
	public Mensagem obterUmMensagem(@PathVariable Integer id)
	{
		return mensagemService.obterUm(id);
	}
	
	@RequestMapping("{id}/mensagens")
	public List<Mensagem> obterTodosMensagens(@PathVariable Integer id)
	{
		return mensagemService.obterTodos();
	}
}
