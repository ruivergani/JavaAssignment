package br.com.samuel.controller;

import br.com.samuel.dao.UserDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import br.com.samuel.model.User;


@ManagedBean
@ViewScoped
@SessionScoped


public class UserBean implements Serializable{

	private static final long serialVersionUID = -234991367225053686L;
	private UserDAO userDAO;
	private User user = new User();
	private DataModel<User> users;
	
	public void novo(){
		user = new User();
	}
	
	public String adicionar(){
        String resultado = "falha";
        userDAO = new UserDAO();
        boolean retorno = userDAO.adicionar(user);
 
        if(retorno){
            resultado = "users";
        }
 
        return resultado;
    }
	
	public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
	
	public void selecionar(){
        user = users.getRowData();
        System.out.println("Selecionado = " +user.getIdUsuario() +"|" + user.getUsuario() + "|" + user.getSenha());
    }
	
	public String atualizar(){
        String resultado = "falha";
        userDAO = new UserDAO();
        boolean retorno = userDAO.atualizar(user);
 
        if(retorno){
            resultado = "users";
        }
 
        return resultado;
    }
	
	public String deletar(){
        String resultado = "falha";
        userDAO = new UserDAO();
        boolean retorno = userDAO.deletar(user);
 
        if(retorno){
            resultado = "users";
        }
 
        return resultado;
    }
    
    public DataModel<User> getUsers() {
        userDAO = new UserDAO();
        List<User> userList = userDAO.listar();
        users = new ListDataModel<User>(userList);
        return users;
    }
 
    public void setUsers(DataModel<User> users) {
        this.users = users;
    }
}
