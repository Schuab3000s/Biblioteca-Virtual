package Biblioteca_PI.model;

public class Emprestimo {

    private Livros livro;
    private Cliente cliente;
    private String data;
    private boolean devolvido;
    
    public Emprestimo(Livros livro, Cliente cliente, String data) {
        this.livro = livro;
        this.cliente = cliente;
        this.data = data;
        this.devolvido = false; 
    }
    
    public Emprestimo(){
        
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public Livros getLivro() {
        return livro;
    }

    public void setLivro(Livros livro) {
        this.livro = livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
