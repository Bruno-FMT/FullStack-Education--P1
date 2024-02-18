import dados.DadosAlunos;
import objetos.Aluno;
import util.Display;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Scanner scan = new Scanner(System.in);
        Aluno aluno = new Aluno();
        Display.displayAluno(scan, aluno);
    }
}