package br.edu.infnet.apppousada2;

import java.sql.SQLException;

import br.edu.infnet.apppousada2.modelo.persistencia.JdbcUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException
    {
    	JdbcUtil.obterConexao();
		System.out.println( "Hello!" );
    }
}