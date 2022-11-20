package br.edu.infnet.apppousada2.modelo.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import br.edu.infnet.apppousada2.modelo.entidades.Hospede;
import br.edu.infnet.apppousada2.modelo.persistencia.JdbcUtil;

public class HospedeDAO extends JdbcDAO <Hospede>{

	public HospedeDAO() {
		
	}
	
	

	
	@Override
	public Boolean salvar(Hospede hospede) {
		String sql = "insert into hospede( nome, sexo, cpf, email) values ( ? , ? , ? , ?)";
		//String sql = "insert into hospede( nome, sexo, cpf, email) values ( 'alan' , 'm' , '12345' , 'tese@teste.com')";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, hospede.getNome()); 
			pstm.setString(2, hospede.getSexo()); 
			pstm.setString(3, hospede.getCpf());  
			pstm.setString(4, hospede.getEmail()); 
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Boolean atualizar(Hospede hospede) {
		String sql = "update hospede set nome = ?, sexo = ?, cpf = ?, email = ?  where id = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, hospede.getNome());
			pstm.setString(2, hospede.getSexo()); 
			pstm.setString(3, hospede.getCpf()); 
			pstm.setString(4, hospede.getEmail()); 
			pstm.setLong(5, hospede.getId());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	@Override
	public Boolean deletar(Hospede hospede) {
		String sql = "delete from hospede where id = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, hospede.getId()); 
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<Hospede> listarTodos(){
		String sql = "select * from hospede";
		List<Hospede> hospedes = new ArrayList<>();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				Long id = rs.getLong("id");
				Hospede hospede = new Hospede(id, nome, sexo, cpf, email);
				hospedes.add(hospede);
			}
			return hospedes;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public Hospede obter(Long id){
		
		PreparedStatement stmTeste;
		try {
			
			stmTeste = con.prepareStatement("SELECT * FROM hospede WHERE id = ?");
			stmTeste.setString(1,id.toString());
			
			ResultSet rs = stmTeste.executeQuery();

			if(rs.next()) {
				String nome = rs.getString("nome");
				String sexo = rs.getString("sexo");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				Long idDb = rs.getLong("id");
				Hospede hospede = new Hospede(idDb, nome, sexo, cpf, email);
				return hospede;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return null;
	}
	
	
	
	
}
