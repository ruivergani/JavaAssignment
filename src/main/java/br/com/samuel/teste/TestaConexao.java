package br.com.samuel.teste;

import java.sql.Connection;
import java.sql.SQLException;
import br.com.samuel.dao.Conexao;

public class TestaConexao{
	public static void main(String[]args) throws SQLException{
			Connection connection = new Conexao().getConn();
			System.out.println("Conexão aberta");
			connection.close();
	}
}