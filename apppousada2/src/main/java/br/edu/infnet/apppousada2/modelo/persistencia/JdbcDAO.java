package br.edu.infnet.apppousada2.modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.edu.infnet.apppousada2.modelo.entidades.Hospede;

public abstract class JdbcDAO<T> implements IDAO<T>{

	protected Connection con;
	protected PreparedStatement pstm;
	protected Statement stm;
	protected ResultSet rs;

	public JdbcDAO() {
		super();
		con = JdbcUtil.obterConexao();
	}

}