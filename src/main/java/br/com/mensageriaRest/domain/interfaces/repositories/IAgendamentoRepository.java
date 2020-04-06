package br.com.mensageriaRest.domain.interfaces.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mensageriaRest.domain.entities.Agendamento;

@Repository
public interface IAgendamentoRepository extends CrudRepository<Agendamento, Integer>{

}
