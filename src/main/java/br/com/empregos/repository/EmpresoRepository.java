package br.com.empregos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.empregos.model.Empregos;

public interface EmpresoRepository extends CrudRepository<Empregos, Long> {

}
