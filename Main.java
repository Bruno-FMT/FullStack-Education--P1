import dados.DadosAlunos;
import objetos.Aluno;
import util.Display;
import util.PedirEntrada;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Scanner entrada = new Scanner(System.in);
        imprimirBoasVindas();

        while (true) {
            imprimirMenu();
            int itemSelecionadoMenu = PedirEntrada.pedirInt(entrada);
            switch (itemSelecionadoMenu) {
                case 1: // Sou Funcionário
                    String nomeFuncionario = login(entrada);
                    if (nomeFuncionario.equals("s")){
                        continue;
                    }
                    //TODO: adicionar login / menu de funcionários
                    break;
                case 2: // Sou Aluno
                    String nomeAluno = login(entrada);
                    if (nomeAluno.equals("s")){
                        continue;
                    }
                    Aluno aluno = DadosAlunos.getAlunoPorUsuario(nomeAluno);
                    if (nomeAluno.equals("0")) {
                        aluno = new Aluno();
                        Display.criarAluno(entrada, aluno);
                    }
                    if (aluno == null) {
                        System.out.println("Conta não cadastrada!");
                        continue;
                    }
                    // pagina(aluno) TODO: Método para fluxo de ações
                    //TODO: adicionar login / menu de alunos
                    break;
                case 0:
                    System.out.println("Finalizando programa...");
                    entrada.close();
                    return;
                default:
                    System.out.println("\nOpção invalida, tente novamente.\n");
            }
        }
    }

    public static void imprimirBoasVindas() {
        System.out.println(
            "BEM-VINDO! \n" +
            "Estamos animados para embarcar nessa jornada educacional juntos!"
        );
    }

    public static void imprimirMenu() {
        System.out.println("\n████████████████████████████████████████████");
        System.out.println("                    MENU                    ");
        System.out.println("████████████████████████████████████████████");
        System.out.println("[1] Sou funcionário");
        System.out.println("[2] Sou aluno");
        System.out.println("[0] SAIR");
        System.out.println("████████████████████████████████████████████");
        System.out.print("Por favor, informe qual opção você deseja interagir: ");
    }

    public static String login(Scanner entrada) {
        System.out.println("\n████████████████████████████████████████████");
        System.out.println("                   LOGIN                   ");
        System.out.println("████████████████████████████████████████████");
        System.out.println(
                "Digite seu nome para fazer o login." +
                "\nCaso não tenha cadastro, digite [0]."
        );
        System.out.print("Informe seu nome ou [s] para sair: ");
        return entrada.nextLine();
    }
}