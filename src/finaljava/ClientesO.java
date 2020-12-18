/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaljava;

/**
 *
 * @author Logan
 */
public class ClientesO {
    private int ID;
    private String CPF;
    private String nome;
    private String privilegio;
    private String email;
    private String login;
    private String senha;
    private String celular;
    private String checkagem;

    public ClientesO(String CPF, String nome, String email, String login, String senha, String privilegio, String celular, String checkagem) {
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.privilegio = privilegio;
        this.celular = celular;
        this.checkagem = checkagem;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }
    
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public String getCheckagem() {
        return checkagem;
    }

    public void setCheckagem(String checkagem) {
        this.checkagem = checkagem;
    }

    public ClientesO() {
    }

}