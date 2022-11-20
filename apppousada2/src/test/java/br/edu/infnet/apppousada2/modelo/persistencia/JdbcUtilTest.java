package br.edu.infnet.apppousada2.modelo.persistencia;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import br.edu.infnet.apppousada2.modelo.persistencia.JdbcUtil;

public class JdbcUtilTest {

	@Test
	public void testConexao() {
		try (Connection obterConexao = JdbcUtil.obterConexao()){
			Assert.assertTrue("Conectado", true);
		} catch (SQLException e) {
			fail();
		}
		
	}

}
