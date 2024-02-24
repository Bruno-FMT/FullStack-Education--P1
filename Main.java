import dados.DadosTurmas;
import objetos.Aluno;
import objetos.Turma;
import objetos.funcionarios.Professor;
import util.Display;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Scanner scan = new Scanner(System.in);
        Aluno aluno = new Aluno();
        new Aluno("Jerry Smith", 69, "aluno", "aluno123");
        Display.criarProfessor(scan, new Professor());
        Display.criarAluno(scan, aluno);
    }
}