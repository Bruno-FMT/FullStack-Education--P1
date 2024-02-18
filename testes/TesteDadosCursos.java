package testes;

import dados.DadosCursos;
import objetos.Curso;
import objetos.funcionarios.Professor;

import java.util.ArrayList;

public class TesteDadosCursos {
    public static void main(String[] args) {
        System.out.println("TESTE DADOS CURSOS");
        Curso curso = new Curso("FullStack", professores());
        Curso curso2 = new Curso("Front-end", professores());
        DadosCursos.adicionarCurso(curso);

        System.out.println("getCursosCadastrados deve retornar a lista de todos os cursos cadastrados");
        System.out.println(DadosCursos.getCursosCadastrados());

        System.out.println("\nadicionarCurso deve adicionar um novo curso a lista de cursos cadastrados");
        DadosCursos.adicionarCurso(curso2);
        System.out.println(DadosCursos.getCursosCadastrados());

        System.out.println("\nadicionarCurso já cadastrado deve lançar exceção: Curso já cadastrado");
        try {
            DadosCursos.adicionarCurso(curso2);
            System.out.println(DadosCursos.getCursosCadastrados());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosCursos.getCursosCadastrados());
        }

        System.out.println("\nremoverCurso deve remover o curso passado por parâmetro");
        DadosCursos.removerCurso(curso2);
        System.out.println(DadosCursos.getCursosCadastrados());

        System.out.println("\nremoverCurso() posição inexistente deve lançar exceção: Nenhum diretor encontrado com o id informado");
        try {
            DadosCursos.removerCurso(curso2);
            System.out.println(DadosCursos.getCursosCadastrados());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosCursos.getCursosCadastrados());
        }

        System.out.println("\nadicionarCursos deve adicionar um array de novos cursos a lista de cursos cadastrados");
        DadosCursos.adicionarCursos(arrayCursos());
        System.out.println(DadosCursos.getCursosCadastrados());

        System.out.println("\nadicionarCursos já cadastrado deve lançar exceção: Curso já cadastrado");
        try {
            DadosCursos.adicionarCursos(arrayCursos());
            System.out.println(DadosCursos.getCursosCadastrados());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosCursos.getCursosCadastrados());
        }

        System.out.println("**** TESTE DADOS CURSOS CONCLUÍDO COM SUCESSO! ****");
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
    public static ArrayList<Curso> arrayCursos() {
        ArrayList<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Java", professores()));
        cursos.add(new Curso("JS", professores()));
        cursos.add(new Curso("CSS", professores()));
        return cursos;
    }
}
