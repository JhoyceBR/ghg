package sistemadentista;

//atributos em comum aos funcionarios e os pacientes 

import java.util.Date;

public abstract class Pessoa {
    
    protected int id;
    protected String nome;
    protected String cpf;
    protected String celular;
    protected String email;
    protected Date diaPresente;


    public Pessoa(int id, String nome, String cpf, String celular, String email, Date diaPresente) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
        this.diaPresente = diaPresente;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDiaPresente() {
        return diaPresente;
    }

    public void setDiaPresente(Date diaPresente) {
        this.diaPresente = diaPresente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}