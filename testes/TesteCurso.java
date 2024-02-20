package testes;

import dados.DadosCursos;
import objetos.Curso;
import objetos.funcionarios.Professor;

import java.util.ArrayList;

public class TesteCurso {
    public static void main(String[] args) {
        System.out.println("TESTES CURSO");
        professores2.add(professor1);
        professores2.add(professor4);
        professores.add(professor3);
        professores.add(professor2);
        System.out.println("Curso deve receber um nome em String e um ArrayList de Professores");
        Curso curso = new Curso("FullStack", professores);
        System.out.println(curso);

        System.out.println("\ngetNome deve retornar uma String com o nome do curso");
        System.out.println(curso.getNome());

        System.out.println("\nsetNome deve incluir um novo nome ao curso");
        curso.setNome("Front-end");
        System.out.println(curso.getNome());

        System.out.println("\nsetNome em branco deve lançar exceção: Nome não pode estar em branco.");
        try {
            curso.setNome("");
            System.out.println(curso.getNome());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(curso.getNome());
        }

        System.out.println("\ngetProfessores deve retornar um Array com todos os professores do curso");
        System.out.println(curso.getProfessores());

        System.out.println("\nsetProfessores deve incluir diversos professores ao curso");
        curso.setProfessores(professores2);
        System.out.println(curso.getProfessores());

        System.out.println("\nsetProfessores com usuário já cadastrado deve lançar exceção: Professor já cadastrado.");
        try {
            curso.setProfessores(professores2);
            System.out.println(curso.getProfessores());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(curso.getProfessores());
        }

        System.out.println("\nsetProfessor deve incluir um novo professor ao curso");
        curso.setProfessor(new Professor("João Silva e Silva", 40, 3000.50, 3, "joaos", "senha1234"));
        System.out.println(curso.getProfessores());

        System.out.println("\nsetProfessor com usuário já cadastrado deve lançar exceção: Professor já cadastrado.");
        try {
            curso.setProfessor(new Professor("João Silva e Silva", 40, 3000.50, 3, "joaosilva", "senha1234"));
            System.out.println(curso.getProfessores());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(curso.getProfessores());
        }

        System.out.println("\ntoString deve trazer nome do curso e os dados dos professores do curso");
        System.out.println(curso.toString());

        System.out.println("**** TESTE CURSO CONCLUÍDO COM SUCESSO! ****");
    }

    public static Professor professor1 = new Professor("João Silva", 40, 3000.50, 3, "joaosilva", "senha1234");
    public static Professor professor2 = new Professor("Maria Oliveira", 50, 3000.00, 3, "mariaoliviera", "senha1234");
    public static Professor professor3 = new Professor("Carlos Santos", 35, 2000.50, 2, "carlossantos", "senha1234");
    public static Professor professor4 = new Professor("Ana Pereira", 34, 2000.00, 2, "anapereira", "senha1234");
    public static ArrayList<Professor> professores2 = new ArrayList<>();
    public static ArrayList<Professor> professores = new ArrayList<>();

}
