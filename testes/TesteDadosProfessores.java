package testes;

import dados.DadosProfessores;
import objetos.funcionarios.Professor;

import java.util.ArrayList;

public class TesteDadosProfessores {
    public static void main(String[] args) {
        System.out.println("TESTE DADOS DIRETORES");
        Professor professor = new Professor("João da Silva", 40, 5000.00, 10, "joaosilva", "senha1234");

        System.out.println("getProfessoresCadastrados deve retornar a lista de todos os professores cadastrados");
        System.out.println(DadosProfessores.getProfessoresCadastrados());

        System.out.println("\nadicionarProfessor deve adicionar um novo professor a lista de professores cadastrados, isso ocorre quando o diretor é cadastrado");
        Professor professor2 = new Professor("Maria da Silva", 50, 2500.00, 5, "mariasilva", "senha1234");

        System.out.println("\nadicionarProfessor já cadastrado deve lançar exceção: Professor já cadastrado");
        try {
            DadosProfessores.adicionarProfessor(professor2);
            System.out.println(DadosProfessores.getProfessoresCadastrados());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosProfessores.getProfessoresCadastrados());
        }

        System.out.println("\nremoverProfessorPorId deve remover da lista de professores cadastrados o professor na posição informada");
        DadosProfessores.removerProfessorPorId(1);
        System.out.println(DadosProfessores.getProfessoresCadastrados());

        System.out.println("\nremoverProfessorPorId posição inexistente deve lançar exceção: Nenhum professor encontrado com o id informado");
        try {
            DadosProfessores.removerProfessorPorId(30);
            System.out.println(DadosProfessores.getProfessoresCadastrados());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosProfessores.getProfessoresCadastrados());
        }

        System.out.println("\ngetProfessorPorId trará as informações do professor na posição informada");
        System.out.println(DadosProfessores.getProfessorPorId(0));

        System.out.println("\ngetProfessorPorId posição inexistente deve lançar exceção: Nenhum professor encontrado com o id informado");
        try {
            DadosProfessores.getProfessorPorId(30);
            System.out.println(DadosProfessores.getProfessoresCadastrados());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosProfessores.getProfessoresCadastrados());
        }

        System.out.println("**** TESTE DADOS PROFESSORES CONCLUÍDO COM SUCESSO! ****");
    }

    public static ArrayList<Professor> professores() {
        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(new Professor("João Silva", 40, 3000.50, 3, "joaosil", "senha1234"));
        professores.add(new Professor("Maria Oliveira", 50, 3000.00, 3, "mariaoliveira", "senha1234"));
        return professores;
    }
}
