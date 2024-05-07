package Biblioteca_PI.model;

public class Funcionario {
    
    String nome, cpf, senha, email;

    public Funcionario(String nome, String senha, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
