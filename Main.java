import dados.DadosAlunos;
import dados.DadosDiretores;
import dados.DadosProfessores;
import objetos.Aluno;
import objetos.funcionarios.Diretor;
import objetos.funcionarios.Professor;
import util.Display;
import util.PedirEntrada;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Scanner entrada = new Scanner(System.in);

        new Aluno("André Santana Nunes", 32, "andre", "senha123");
        new Aluno("Oswald Hitler", 81, "oswald", "senha123");
        new Aluno("Gabriel Agustin", 28, "gabriel", "senha123");

        imprimirBoasVindas();

        while (true) {
            imprimirMenu();
            int itemSelecionadoMenu = PedirEntrada.pedirInt(entrada);
            switch (itemSelecionadoMenu) {
                case 1: // Sou Funcionário
                    String nomeFuncionario = login(entrada);
                    if (nomeFuncionario.equals("s")) {
                        continue;
                    }

                    Diretor diretor = DadosDiretores.getDiretorPorUsuario(nomeFuncionario);
                    Professor professor = DadosProfessores.getProfessorPorUsuario(nomeFuncionario);

                    if (diretor == null) {
                        if (professor == null) {
                            System.out.println("Conta não cadastrada!");
                            continue;
                        }
//                        pagina(professor);
                    } else if (professor != null) {
                        System.out.println("Qual seu cargo?");
                        System.out.println("[1] Sou Diretor");
                        System.out.println("[2] Sou Professor");
                        System.out.println("[0] SAIR");
                        switch(PedirEntrada.pedirByte(entrada)) {
                            case 1:
//                                pagina(diretor);
                                break;
                            case 2:
//                                pagina(professor);
                                break;
                            default:
                                continue;
                        }
                    } else {
                        //pagina(diretor) TODO: Método para fluxo de ações
                    }
                    //TODO: adicionar login / menu de funcionários
                    break;
                case 2: // Sou Aluno
                    Aluno aluno;
                    switch (loginCadastro(entrada)) {
                        case 1:
                            String nomeAluno = login(entrada);
                            try {
                                Aluno alunoEncontrado = DadosAlunos.getAlunoPorUsuario(nomeAluno);
                                System.out.print("Digite a senha: ");
                                String senha = PedirEntrada.pedirString(entrada);
                                if (alunoEncontrado.getSenha().equals(senha)) {
                                    aluno = alunoEncontrado;
                                } else {
                                    throw new IllegalArgumentException("Senha inválida!");
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                continue;
                            }
                            break;
                        case 2:
                            aluno = new Aluno();
                            Display.criarAluno(entrada, aluno);
                            break;
                        default:
                            continue;
                    }
                    pagina(aluno); // TODO: Método para fluxo de ações
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

    public static int loginCadastro(Scanner entrada) {
        return Display.menuOpcoes(entrada, "ENTRAR", new String[]{"Entrar em uma conta existente", "Criar uma nova conta"});
    }

    public static String login(Scanner entrada) {
        System.out.println("\n████████████████████████████████████████████");
        System.out.println("                   LOGIN                   ");
        System.out.println("████████████████████████████████████████████");
        System.out.print("Para fazer login, informe seu usuário: ");
        return entrada.nextLine();
    }

    public static void pagina(Object usuario) {
        Class<?> classe = usuario.getClass();
        if (classe == Diretor.class) {
            Display.pagina((Diretor) usuario);
        } else if (classe == Professor.class) {
            Display.pagina((Professor) usuario);
        } else if (classe == Aluno.class) {
            Display.pagina((Aluno) usuario);
        }
    }
}