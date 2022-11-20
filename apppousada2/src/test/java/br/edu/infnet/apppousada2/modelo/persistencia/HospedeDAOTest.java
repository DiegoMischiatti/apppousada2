package br.edu.infnet.apppousada2.modelo.persistencia;



import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.infnet.apppousada2.modelo.entidades.Hospede;
import br.edu.infnet.apppousada2.modelo.persistencia.HospedeDAO;
import br.edu.infnet.apppousada2.modelo.persistencia.IDAO;

public class HospedeDAOTest {
	
	
	@Before
	public void inicializar() {
		IDAO hospedeDAO = new HospedeDAO();
		Hospede hospede = new Hospede(null, "JOSE", "M", "12345678901", "jose@teste.com"); 
		hospedeDAO.salvar(hospede);
		
		
	}

	@Test
	public void test() {
		IDAO hospedeDAO = new HospedeDAO();
		Hospede hospede = new Hospede(null, "JOSE", "M", "12345678901", "jose@teste.com"); 
		boolean validacao = hospedeDAO.salvar(hospede);
		Assert.assertTrue(validacao);
	}
	
	@Test
	public void testUpdate() {
		IDAO hospedeDAO = new HospedeDAO();
		List<Hospede> lista = hospedeDAO.listarTodos();
		
		
		Hospede hospede = new Hospede(1L, "MARIA", "F", "12345678901", "maria@teste.com"); 
		boolean validacao = hospedeDAO.atualizar(hospede);
		Assert.assertTrue(validacao);
	}
	
	@Test
	public void testdelete() {
		IDAO hospedeDAO = new HospedeDAO();
		
		List<Hospede> lista = hospedeDAO.listarTodos();
		
		
		Hospede hospede = new Hospede(lista.get(0).getId(), null, null, null, null);
		boolean validacao = hospedeDAO.deletar(hospede);
		Assert.assertTrue(validacao);
	}
	
	@Test
	public void testListaHospedes() {
		IDAO hospedeDAO = new HospedeDAO();
		
		List<Hospede> lista = hospedeDAO.listarTodos();
		Assert.assertTrue(lista.size() > 0);
	}
	
	@Test
	public void testObterHospede() {
		
		IDAO hospedeDAO = new HospedeDAO();
		
		List<Hospede> lista = hospedeDAO.listarTodos();
		
		Hospede hospede = hospedeDAO.obter(lista.get(0).getId());
		System.out.println(hospede.toString());
		Assert.assertNotNull(hospede);
	}
	
	
}