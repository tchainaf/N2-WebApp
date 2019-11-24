package ftt.webapp.model;

import java.io.Serializable;
import java.util.Date;

public class Pessoa implements Serializable {

    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private Date dataNasc;

    public Pessoa(){}

    public Pessoa(int id, String nome, String tel, String email, String end, Date dtNasc){
        this.setId(id);
        this.setNome(nome);
        this.setTelefone(tel);
        this.setEmail(email);
        this.setEndereco(end);
        this.setDataNasc(dtNasc);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone.length() < 8){
            System.err.println("Telefone incompleto!");
            return;
        }
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
}
