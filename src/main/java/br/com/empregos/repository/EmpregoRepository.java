package br.com.empregos.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.empregos.model.Emprego;

public interface EmpregoRepository extends CrudRepository<Emprego, Long> {

}
