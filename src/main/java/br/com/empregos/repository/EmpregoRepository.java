package br.com.empregos.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.empregos.model.Emprego;

public interface EmpregoRepository extends JpaRepository<Emprego, Long> {

	/*
	 * Posso Sobrecrever os Metodos da Interface AQUI.
	 * Aqui Retorna Apenas um Objeto Emprego.
	 */
	Emprego findAllById(Long id);
	
	/*
	 * Posso Sobrecrever os Metodos da Interface AQUI.
	 * Aqui Retorna uma LISTA DE Emprego
	 */
	List<Emprego> findAll();
	
	/*
	 * 
	 */
	
}
