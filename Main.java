import dados.DadosAlunos;
import dados.DadosDiretores;
import dados.DadosProfessores;
import objetos.Aluno;
import objetos.Curso;
import objetos.Turma;
import objetos.funcionarios.Diretor;
import objetos.funcionarios.Professor;
import util.Display;
import util.PedirEntrada;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Scanner entrada = new Scanner(System.in);
        popularBanco();
        imprimirBoasVindas();

        while (true) {
            imprimirMenu();
            int itemSelecionadoMenu = PedirEntrada.pedirInt(entrada);
            switch (itemSelecionadoMenu) {
                case 1: // Sou Funcionário
                    int opcao = Display.menuOpcoes(entrada, "Qual seu cargo?", new String[]{"Diretor", "Professor"});
                    String nomeFuncionario = login(entrada);
                    switch (opcao) {
                        case 1:
                            Diretor diretor;
                            try {
                                Diretor diretorEncontrado = DadosDiretores.getDiretorPorUsuario(nomeFuncionario);
                                System.out.print("Digite a senha: ");
                                String senha = PedirEntrada.pedirString(entrada);
                                if (diretorEncontrado.getSenha().equals(senha)) {
                                    diretor = diretorEncontrado;
                                } else {
                                    throw new IllegalArgumentException("Senha inválida!");
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                continue;
                            }
                            Display.pagina(diretor);
                            break;
                        case 2:
                            Professor professor;
                            try {
                                Professor professorEncontrado = DadosProfessores.getProfessorPorUsuario(nomeFuncionario);
                                System.out.print("Digite a senha: ");
                                String senha = PedirEntrada.pedirString(entrada);
                                if (professorEncontrado.getSenha().equals(senha)) {
                                    professor = professorEncontrado;
                                } else {
                                    throw new IllegalArgumentException("Senha inválida!");
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                continue;
                            }
                            Display.pagina(professor);
                            break;
                        case 0:
                            System.out.println("voltando ao menu anterior....");
                            return;
                        default:
                            System.out.println("opção invalida!");
                            continue;
                    }
                    break;
                case 2:
                    Aluno aluno = menuAluno(entrada);
                    if (aluno == null) { continue; }
                    Display.pagina(aluno);
                    break;
                case 0:
                    System.out.println("Finalizando programa...");
                    entrada.close();
                    return;
                default:
                    System.out.println("\nOpção invalida, tente novamente.\n");
                    continue;
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

    public static int loginCadastro(Scanner entrada) {
        return Display.menuOpcoes(
                entrada,
                "ENTRAR",
                new String[]{"Entrar em uma conta existente", "Criar uma nova conta"}
        );
    }

    public static String login(Scanner entrada) {
        System.out.println("\n████████████████████████████████████████████");
        System.out.println("                   LOGIN                   ");
        System.out.println("████████████████████████████████████████████");
        System.out.print("Para fazer login, informe seu usuário: ");
        return entrada.nextLine();
    }

    public static void popularBanco() {
        new Diretor("César Abascal", 29, 3900, 8, "cesar", "diretor123");
        new Professor("André Santana Nunes", 32, 2600, 6, "andre", "senha123");
        new Aluno("Oswald Hitler", 81, "oswald", "senha123");
        new Professor("Gabriel Agustin", 28, 2600, 4, "gabriel", "senha123");
        new Turma(new Curso("JavaScript", (ArrayList<Professor>) DadosProfessores.getProfessoresCadastrados()), 2024);
    }

    public static Aluno menuAluno(Scanner entrada) {
        Aluno aluno = new Aluno();
        switch (loginCadastro(entrada)) {
            case 1:
                String nomeAluno = login(entrada);
                try {
                    Aluno alunoEncontrado = DadosAlunos.getAlunoPorUsuario(nomeAluno);
                    String senha = pedirSenha(entrada);
                    boolean senhaCorreta = alunoEncontrado.getSenha().equals(senha);
                    int limiteTentativas = 3;
                    int tentativas = 0;
                    while (!senhaCorreta) {
                        tentativas++;
                        if (tentativas > limiteTentativas) {
                            System.out.println("Limite de tentativas excedido.");
                            return menuAluno(entrada);
                        }
                        System.out.println("Senha inválida! Tentativas " + tentativas + "/" + limiteTentativas);
                        senha = pedirSenha(entrada);
                        senhaCorreta = alunoEncontrado.getSenha().equals(senha);
                    }
                    aluno = alunoEncontrado;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return menuAluno(entrada);
                }
                break;
            case 2:
                aluno = new Aluno();
                try {
                    Display.criarAluno(entrada, aluno);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 0:
                System.out.println("Retornando ao menu anterior...");
                return null;
            default:
                System.out.println("\nOpção invalida, tente novamente.\n");
                return menuAluno(entrada);
        }
        return aluno;
    }

    public static String pedirSenha(Scanner entrada) {
        System.out.print("Digite a senha: ");
        String senha = PedirEntrada.pedirString(entrada);
        return senha;
    }
}