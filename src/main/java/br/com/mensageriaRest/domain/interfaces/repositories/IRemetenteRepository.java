package br.com.mensageriaRest.domain.interfaces.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.mensageriaRest.domain.entities.Remetente;

@Repository
public interface IRemetenteRepository extends CrudRepository<Remetente, Integer>{

}
