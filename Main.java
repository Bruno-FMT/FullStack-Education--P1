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
        Aluno aluno2 = new Aluno("Maria Silva", 30, "aluno2", "aluno123");
        alunos.add(aluno);
        alunos2.add(aluno);
        alunos2.add(aluno2);

        ArrayList<Professor> professores = new ArrayList<>();
        Professor professor = new Professor("Gustavo", 30, 10000.00, 40);
        professores.add(professor);

        Curso curso = new Curso("Java", professores);
        Curso curso2 = new Curso("HTML", professores);

        Turma java = new Turma(curso, alunos, 2025);
        Turma html = new Turma(curso2, alunos2, 2024);

        System.out.println("professor.getCursos()");
        System.out.println(professor.getCursos());
        System.out.println("professor.getTurmas()");
        System.out.println(professor.getTurmas());
        System.out.println("professor.getTodosAlunos()");
        System.out.println(professor.getTodosAlunos());
        System.out.println("professor.listarTodosAlunos()");
        professor.listarTodosAlunos();
        System.out.println("professor.listarAlunoPorCurso()");
        professor.listarAlunoPorCurso();

        System.out.println("******FIM*******");
    }
}