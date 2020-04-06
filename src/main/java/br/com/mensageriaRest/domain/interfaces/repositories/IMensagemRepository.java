package br.com.mensageriaRest.domain.interfaces.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mensageriaRest.domain.entities.Mensagem;

@Repository
public interface IMensagemRepository extends CrudRepository<Mensagem, Integer>{

}
