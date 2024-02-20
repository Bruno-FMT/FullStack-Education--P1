package testes;

import dados.DadosCursos;
import objetos.Curso;
import objetos.funcionarios.Professor;

import java.util.ArrayList;

public class TesteDadosCursos {
    public static void main(String[] args) {
        System.out.println("TESTE DADOS CURSOS");
        professores.add(professor1);
        professores.add(professor2);
        Curso curso = new Curso("FullStack", professores);

        System.out.println("getCursosCadastrados deve retornar a lista de todos os cursos cadastrados");
        System.out.println(DadosCursos.getCursosCadastrados());

        System.out.println("\nadicionarCurso deve adicionar um novo curso a lista de cursos cadastrados, isso ocorre quando um novo curso é criado");
        Curso curso2 = new Curso("Front-end", professores);
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

        System.out.println("**** TESTE DADOS CURSOS CONCLUÍDO COM SUCESSO! ****");
    }

    public static ArrayList<Professor> professores = new ArrayList<>();
    public static Professor professor1 = new Professor("João Silva", 40, 3000.50, 3, "joaosilva", "senha1234");
    public static Professor professor2 = new Professor("Maria Oliveira", 50, 3000.00, 3, "mariaoliveira", "senha1234");
}
