package Biblioteca_PI.model;

import java.util.ArrayList;
import java.util.List;

public class Listagem {

    private static final List<Livros> listaLivros = new ArrayList<>();
    private static final List<Cliente> listaCliente = new ArrayList<>();
    private static final List<Funcionario> listaFuncionario = new ArrayList<>();
    private static final List<Emprestimo> listaEmprestimo = new ArrayList<>();

    public static List<Livros>
            ListarLivro() {
        return listaLivros;
    }

    public static void Adicionar(Livros livros) {
        listaLivros.add(livros);
    }

    public static List<Cliente>
            ListarCliente() {
        return listaCliente;
    }

    public static void Adicionar(Cliente cliente) {
        listaCliente.add(cliente);
    }

    public static List<Funcionario>
            ListarFuncionario() {
        return listaFuncionario;
    }

    public static void Adicionar(Funcionario funcionario) {
        listaFuncionario.add(funcionario);
    }

    public static List<Emprestimo>
            ListarEmprestimo() {
        return listaEmprestimo;
    }

    public static void Adicionar(Emprestimo emprestimo) {
        listaEmprestimo.add(emprestimo);
    }
}
