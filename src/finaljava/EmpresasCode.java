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
public class EmpresasCode {
    private Connection con;

    //construtor
    public EmpresasCode(Connection con) {
        this.con = con;
    }
    //getter setters

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String insEmpresa(EmpresasO empresas) {
        String sql = "insert into empresas(codEmpresa,nomeEmpresa,cnpj,razao) values(?,?,?,?)";

        try {
            PreparedStatement prepare = getCon().prepareStatement(sql);
            //inserir valores a tb carros com getters
            prepare.setString(1, empresas.getCodEmpresa());
            prepare.setString(2, empresas.getNomeEmpresa());
            prepare.setString(3, empresas.getCnpj());
            prepare.setString(4, empresas.getRazao());


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
    public String altEmpresas(EmpresasO empresas){
        String sql = "update empresas set codEmpresa = ?, nomeEmpresa = ?,razao = ? where cnpj = ?";
        
        PreparedStatement prepare;
        try {
            prepare = getCon().prepareStatement(sql);
           
            prepare.setString(1, empresas.getCodEmpresa());
            prepare.setString(2, empresas.getNomeEmpresa());
            prepare.setString(3, empresas.getRazao());
            prepare.setString(4, empresas.getCnpj());
            
            if(prepare.executeUpdate() > 0){
            return "Alterado com sucesso!";
            
            }else{
            return "Erro ao alterar!(CNPJ Inválido)";
            }
        } 
        catch (SQLException ex) {
            return ex.getMessage();
        }  
    }
    //excluir dados
    public String exEmpresa(EmpresasO empresas){
        String sql = "delete from empresas where cnpj = ?";
        
        PreparedStatement prepare;
        try {
            prepare = getCon().prepareStatement(sql);
           
            prepare.setString(1, empresas.getCnpj());
            
            if(prepare.executeUpdate() > 0){
            return "Deletado com sucesso!";
            }else{
            return "Erro ao deletar!(CNPJ invalido)";
            }
        } 
        catch (SQLException ex) {
            return ex.getMessage();
        }  
    }
    
    //criação de select
    public List<EmpresasO> busca(){
        //String sql ="select * from empresas where cnpj = ?";
        String sql = "select * from empresas";
        
        //criação de vetor/matriz
        List<EmpresasO> listEmpresas =  new ArrayList<>();
        
        try {
            //EmpresasO x = new EmpresasO();
            
            
            PreparedStatement prepare = getCon().prepareStatement(sql);
             
            //prepare.setString(1, x.getCnpj());
            
            ResultSet rs = prepare.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                EmpresasO cB = new EmpresasO();
                cB.setCodEmpresa(rs.getString(1));
                cB.setCnpj(rs.getString(2));
                
                listEmpresas.add(cB);
                }
                return listEmpresas;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
}
