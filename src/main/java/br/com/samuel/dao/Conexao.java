package br.com.samuel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
	
	public class Conexao {
		 
	    private String URL = "jdbc:mysql://localhost/login";
	    private String USER = "root";
	    private String SENHA = "";
	    private Connection conn;
	 
	    public Conexao() {
	        try {
	        	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	            conn = (Connection) DriverManager.getConnection(URL, USER, SENHA);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public Connection getConn() {
	        return conn;
	    }
	 
	    public void fecharConexao() {
	        try {
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}