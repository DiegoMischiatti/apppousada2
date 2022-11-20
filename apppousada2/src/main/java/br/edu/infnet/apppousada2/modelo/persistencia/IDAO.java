package br.edu.infnet.apppousada2.modelo.persistencia;

import java.util.List;

import br.edu.infnet.apppousada2.modelo.entidades.Hospede;

public interface IDAO<T> {

	Boolean salvar(T obj);

	Boolean atualizar(T obj);

	Boolean deletar(T obj);

	List<T> listarTodos();

	Hospede obter(Long id);

}