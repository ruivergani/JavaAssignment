package br.com.samuel.dao;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.samuel.model.User;

public class UserDAO {
	private Conexao conexao;
	private Statement stmt;
	private boolean sucesso = false;
	
	public UserDAO(){
		conexao = new Conexao();
		try {
            stmt = (Statement) conexao.getConn().createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}

	public boolean adicionar(User user) {
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário cadastrado com sucesso!"));
        try {
            stmt.execute("INSERT INTO login (usuario, senha) VALUES ('" + user.getUsuario() + "','" + user.getSenha() + "')");
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	conexao.fecharConexao();
        }
 
        return sucesso;
    }
	
	public boolean atualizar(User user) {
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário Atualizado com sucesso!"));
        try {
            stmt.execute("UPDATE login SET usuario = '" + user.getUsuario() + "', senha = '" + user.getSenha() + "' WHERE idUsuario = '" + user.getIdUsuario() + "'");
            sucesso = true;
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        } 
        
        finally {
        	conexao.fecharConexao();
        }
 
        return sucesso;
    }
	
	public boolean deletar(User user) {
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário Deletado com sucesso!"));
        try {
            stmt.execute("DELETE FROM login WHERE idUsuario = '" + user.getIdUsuario() + "'");
            sucesso = true;
        } 
        
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Chegou na Servlet8");
        } 
        
        finally {
        	conexao.fecharConexao();
        }
 
        return sucesso;
    }
	
	public List<User> listar() {
        List<User> users = new ArrayList<User>();
        
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM login ORDER BY usuario");
            while (rs.next()) {
                User user = new User();
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setUsuario(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
 
                users.add(user);
            }
 
        }
        
        catch (Exception e) {
            e.printStackTrace();
        } 
        
        finally {
            conexao.fecharConexao();
        }
 
        return users;
    }
}


