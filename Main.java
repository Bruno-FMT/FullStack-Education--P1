import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        imprimirBoasVindas();

        while (true) {
            imprimirMenu();
            int itemSelecionadoMenu = Utils.nextInt(entrada);
            switch (itemSelecionadoMenu) {
                case 1:
                    String nomeFuncionario = login(entrada);
                    if (nomeFuncionario.equals("s")){
                        continue;
                    }
                    //TODO: adicionar login / menu de funcionários
                    break;
                case 2:
                    String nomeAluno = login(entrada);
                    if (nomeAluno.equals("s")){
                        continue;
                    }
                    //TODO: adicionar login / menu de alunos
                    break;
                case 0:
                    System.out.println("Finalizando programa....");
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
                "Digite seu nome para fazer o login, " +
                "caso não tenha cadastro iremos criar seu usuário."
        );
        System.out.print("Informe seu nome ou [s] para sair: ");
        String nome = entrada.nextLine();
        return nome;
    }
}