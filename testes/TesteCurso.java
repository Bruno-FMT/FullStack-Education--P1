package testes;

import dados.DadosCursos;
import objetos.Aluno;
import objetos.Curso;
import objetos.funcionarios.Professor;

import java.util.ArrayList;

public class TesteCurso {
    public static void main(String[] args) {
        System.out.println("TESTES CURSO");
        System.out.println("Curso deve receber um nome em String e um ArrayList de Professores");
        Curso curso = new Curso("FullStack", professores());
        DadosCursos.adicionarCurso(curso);
        System.out.println(curso);

        System.out.println("\nNome em branco deve lançar exceção: Nome não pode estar em branco.");
        try {
            Curso cursoErroNome = new Curso("", professores());
            System.out.println(cursoErroNome);
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

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

        System.out.println("\nsetProfessor deve incluir um novo professor ao curso");
        curso.setProfessor(new Professor("João Silva e Silva", 40, 3000.50, 3));
        System.out.println(curso.getProfessores());

        System.out.println("\nsetProfessor com nome já cadastrado deve lançar exceção: Professor já cadastrado.");
        try {
            curso.setProfessor(new Professor("João Silva e Silva", 40, 3000.50, 3));
            System.out.println(curso.getProfessores());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(curso.getProfessores());
        }

        System.out.println("\nsetProfessores deve incluir diversos professores ao curso");
        curso.setProfessores(professores2());
        System.out.println(curso.getProfessores());

        System.out.println("\nsetProfessores com nome já cadastrado deve lançar exceção: Professor já cadastrado.");
        try {
            curso.setProfessores(professores2());
            System.out.println(curso.getProfessores());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(curso.getProfessores());
        }

        System.out.println("\ntoString deve trazer nome do curso e os dados dos professores do curso");
        System.out.println(curso.toString());

        System.out.println("**** TESTE CURSO CONCLUÍDO COM SUCESSO! ****");
    }

    public static ArrayList<Professor> professores() {
        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(new Professor("João Silva", 40, 3000.50, 3));
        professores.add(new Professor("Maria Oliveira", 50, 3000.00, 3));

        return professores;
    }
    public static ArrayList<Professor> professores2() {
        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(new Professor("Carlos Santos", 35, 2000.50, 2));
        professores.add(new Professor("Ana Pereira", 34, 2000.00, 2));

        return professores;
    }
}
