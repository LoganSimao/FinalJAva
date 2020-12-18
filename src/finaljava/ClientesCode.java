/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaljava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Logan
 */
public class ClientesCode {
    private Connection con;

    //construtor
    public ClientesCode(Connection con) {
        this.con = con;
    }
    //getter setters

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String insCliente(ClientesO clients) {
        String sql = "insert into clientes(CPF,nome,email,login,senha,celular) values(?,?,?,?,?,?)";

        try {
            PreparedStatement prepare = getCon().prepareStatement(sql);
            //inserir valores a tb carros com getters
            prepare.setString(1, clients.getCPF());
            prepare.setString(2, clients.getNome());
            prepare.setString(3, clients.getEmail());
            prepare.setString(4, clients.getLogin());
            prepare.setString(5, clients.getSenha());
            prepare.setString(6, clients.getCelular());

            if (prepare.executeUpdate() > 0) {
                return "Inserido com sucesso!";
            } else {
                return "Erro ao inserir carro!";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    //alterar dados
    public String altClientes(ClientesO clients){
        String sql = "update clientes set nome = ?, email = ?,login = ?, senha = ?, privilegio = ?, celular = ?  where CPF = ?";
        
        PreparedStatement prepare;
        try {
            prepare = getCon().prepareStatement(sql);
           
            prepare.setString(1, clients.getNome());
            prepare.setString(2, clients.getEmail());
            prepare.setString(3, clients.getLogin());
            prepare.setString(4, clients.getSenha());
            prepare.setString(5, clients.getCelular());
            prepare.setString(6, clients.getCPF());
            
            if(prepare.executeUpdate() > 0){
            return "Alterado com sucesso!";
            
            }else{
            return "Erro ao alterar!(CPF Inválido)";
            }
        } 
        catch (SQLException ex) {
            return ex.getMessage();
        }  
    }
    //excluir dados
    public String exCliente(ClientesO clients){
        String sql = "delete from clientes where CPF = ?";
        
        PreparedStatement prepare;
        try {
            prepare = getCon().prepareStatement(sql);
           
            prepare.setString(1, clients.getCPF());
            
            if(prepare.executeUpdate() > 0){
            return "Deletado com sucesso!";
            }else{
            return "Erro ao deletar!(CPF invalido)";
            }
        } 
        catch (SQLException ex) {
            return ex.getMessage();
        }  
    }
    
    //criação de select
    public List<ClientesO> listarTudo(){
        String sql ="select * from clientes";
        //criação de vetor/matriz
        List<ClientesO> listClients =  new ArrayList<>();
        
        try {
            PreparedStatement prepare = getCon().prepareStatement(sql);
            
            ResultSet rs = prepare.executeQuery();
            if(rs != null){
                while(rs.next()){
                ClientesO cB = new ClientesO();
                cB.setID(rs.getInt(1));
                cB.setCPF(rs.getString(2));
                cB.setNome(rs.getString(3));
                cB.setEmail(rs.getString(4));
                cB.setLogin(rs.getString(5));
                cB.setSenha(rs.getString(6));
                cB.setCelular(rs.getString(7));
                
                listClients.add(cB);
                }
                return listClients;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public String verificarLogin(ClientesO login){
        String sql = "SELECT * FROM clientes WHERE login = ? AND senha = ?";
       // String sql2 = "SELECT privilegio FROM usuarios WHERE login = ? AND senha = ?";
        try {
            PreparedStatement prepare = getCon().prepareStatement(sql);
            
            prepare.setString(1, login.getLogin());
            prepare.setString(2, login.getSenha());
            
            ResultSet rs = prepare.executeQuery();
            //ResultSet ss = prepare.executeQuery(sql2);
            if(rs.next()){
                
                login.setCheckagem("logado");
                
                return "";
            }else{
            return "Erro ao entrar!";
            }
        } 
        catch (SQLException ex) {
            return ex.getMessage();
        }  
    }
    
}
