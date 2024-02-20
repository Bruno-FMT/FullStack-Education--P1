package testes;

import dados.DadosTurmas;
import objetos.Aluno;
import objetos.Curso;
import objetos.Turma;
import objetos.funcionarios.Professor;

import java.util.ArrayList;
import java.util.List;

public class TesteTurma {
    public static void main(String[] args) {
        System.out.println("TESTES TURMA");
        System.out.println("Turma deve receber um curso, um ano de início em int e um ArrayLis de alunos");
        Turma turma = new Turma(curso(), 2024);
        System.out.println(turma);

        System.out.println("\nPorém o ArrayLis de alunos que é opcional");
        Turma turmaComAlunos = new Turma(curso(), 2024, alunos);
        System.out.println(turmaComAlunos);

        System.out.println("\nlistarAlunos deve mostrar na tela a lista de alunos cadastrados na turma");
        turmaComAlunos.listarAlunos();
        turma.listarAlunos();

        System.out.println("\nadicionarAluno deve adicionar um novo aluno a turma");
        turmaComAlunos.adicionarAluno(new Aluno("André Silva", 16, "andresilva", "senha1234"));
        turmaComAlunos.listarAlunos();

        System.out.println("\nadicionarAluno já existente deve lançar exceção: Aluno já cadastrado.");
        try {
            turmaComAlunos.adicionarAluno(new Aluno("André Almeida", 16, "andrealmeida", "senha1234"));
            turmaComAlunos.listarAlunos();
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            turmaComAlunos.listarAlunos();
        }

        System.out.println("\nsetAlunos deve adicionar um Array com novos alunos a turma, sobrescrevendo a lista de alunos pela nova lista");
        turmaComAlunos.setAlunos(alunos2);
        turmaComAlunos.listarAlunos();

        System.out.println("\nsetAlunos já existente deve lançar exceção: Aluno já cadastrado.");
        try {
            turmaComAlunos.setAlunos(alunos2);
            turmaComAlunos.listarAlunos();
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            turmaComAlunos.listarAlunos();
        }

        System.out.println("\nremoverAluno deve remover o aluno passado por parâmetro");
        turmaComAlunos.removerAluno(aluno4);
        turmaComAlunos.listarAlunos();

        System.out.println("\nremoverAluno deve remover o aluno na posição passada por parâmetro");
        turmaComAlunos.removerAluno(1);
        turmaComAlunos.listarAlunos();

        System.out.println("\nremoverAluno inexistente deve lançar exceção: Aluno não está cadastrado nesta turma");
        try {
            turmaComAlunos.removerAluno(aluno4);
            turmaComAlunos.listarAlunos();
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            turmaComAlunos.listarAlunos();
        }

        System.out.println("\nremoverAluno posição inexistente deve lançar exceção: Não há um aluno na posição informada");
        try {
            turmaComAlunos.removerAluno(30);
            turmaComAlunos.listarAlunos();
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            turmaComAlunos.listarAlunos();
        }

        System.out.println("\ngetCurso deve retornar dados do curso cadastrado a turma");
        System.out.println(turmaComAlunos.getCurso());

        System.out.println("\nsetCurso deve alterar o curso cadastrado a turma");
        turmaComAlunos.setCurso(curso2());
        System.out.println(turmaComAlunos.getCurso());

        System.out.println("\ngetAlunos deve retornar dados dos alunos cadastrados na turma");
        System.out.println(turmaComAlunos.getAlunos());

        System.out.println("\ngetAlunos deve retornar null se não houver alunos cadastrados a turma");
        System.out.println(turma.getAlunos());

        System.out.println("\ngetAnoInicio deve retornar o ano de ínicio da turma");
        System.out.println(turma.getAnoInicio());

        System.out.println("\nsetAnoInicio deve alterar o ano de ínicio da turma");
        turma.setAnoInicio(2025);
        System.out.println(turma.getAnoInicio());

        System.out.println("\ntoString deve trazer ano de inicío, nome do curso, professores do curso e alunos da turma");
        System.out.println(turmaComAlunos.toString());
        System.out.println(turma.toString());

        System.out.println("**** TESTE TURMA CONCLUÍDO COM SUCESSO! ****");
    }

    public static Curso curso(){
        return new Curso("FullStack", professores);
    }
    public static Curso curso2(){
        return new Curso("Front-end", professores);
    }
    public static Professor professor1 = new Professor("João Silva", 40, 3000.50, 3, "joaosilva", "senha1234");
    public static Professor professor2 = new Professor("Maria Oliveira", 50, 3000.00, 3, "mariaoliveira", "senha1234");
    public static ArrayList<Professor> professores = new ArrayList<>(List.of(professor1, professor2));

    public static Aluno aluno1 =new Aluno("André Almeida", 16, "andre", "senha1234");
    public static Aluno aluno2 =new Aluno("Sofia Rodrigues", 17, "sofiarodrigues", "senha1234");
    public static Aluno aluno3 =new Aluno("Carolina Gonçalves", 21, "carolinagoncalves", "senha1234");
    public static ArrayList<Aluno> alunos = new ArrayList<>(List.of(aluno1, aluno2, aluno3));

    public static Aluno aluno4 = new Aluno("Tiago Ferreira", 18, "tiagoferreira", "senha1234");
    public static Aluno aluno5 = new Aluno("Mariana Sousa", 19, "marinasouza", "senha1234");
    public static Aluno aluno6 = new Aluno("Daniel Martins", 20, "danielamartins", "senha1234");
    public static ArrayList<Aluno> alunos2 = new ArrayList<>(List.of(aluno4, aluno5, aluno6));
}
