package br.com.empregos.repository;


import org.springframework.data.repository.CrudRepository;

import br.com.empregos.model.Emprego;

public interface EmpregoRepository extends CrudRepository<Emprego, Long> {

	/*
	 * Posso Sobrecrever os Metodos da Interface AQUI.
	 * Aqui Retorna Apenas um Objeto Emprego.
	 */
	Emprego findAllById(Long id);
	
	/*
	 * Posso Sobrecrever os Metodos da Interface AQUI.
	 * Aqui Retorna uma LISTA DE Emprego
	 */
	Iterable<Emprego> findAll();
	
}
