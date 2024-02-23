import dados.DadosAlunos;
import dados.DadosTurmas;
import objetos.Aluno;
import objetos.Curso;
import objetos.Turma;
import objetos.funcionarios.Professor;
import util.Display;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Aluno> alunos2 = new ArrayList<>();
        Aluno aluno = new Aluno("Jerry Smith", 69, "aluno", "aluno123");
        alunos.add(aluno);
        alunos2.add(aluno);
        ArrayList<Professor> professores = new ArrayList<>();
        professores.add(new Professor("Gustavo", 30, 10000.00, 40));
        Curso curso = new Curso("Java", professores);
        Curso curso2 = new Curso("HTML", professores);
        Turma java = new Turma(curso, alunos, 2025);
        Turma html = new Turma(curso2, alunos2, 2024);
        aluno.listarCursosCadastrados();
        aluno.sairCurso(curso2);
        System.out.println();
        aluno.listarCursosCadastrados();
        System.out.println();
        DadosTurmas.listarCursosCadastrados();
        aluno.matricularCurso(curso2);
        System.out.println();
        aluno.listarCursosCadastrados();

        System.out.println("******FIM*******");
    }
}