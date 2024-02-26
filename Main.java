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
            int itemSelecionadoMenu = Display.menuOpcoes(entrada, "MENU", new String[]{"Sou funcionário", "Sou aluno"});
            String itemSelecionado = trataritemSelecionadoMenu(itemSelecionadoMenu);
            switch (itemSelecionado) {
                case "Funcionário":
                    menuFuncionario(entrada);
                    break;
                case "Aluno":
                    Aluno aluno = menuAluno(entrada);
                    if (aluno == null) { continue; }
                    Display.pagina(aluno);
                    break;
                case "Sair":
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
        System.out.print("Para fazer login, informe seu usuário ou [n] para sair: ");
        return PedirEntrada.pedirString(entrada);
    }

    public static void popularBanco() {
        ArrayList<Professor> professores = new ArrayList<>();
        ArrayList<Aluno> alunosTurma1 = new ArrayList<>();
        ArrayList<Aluno> alunosTurma2 = new ArrayList<>();
        new Diretor("César Abascal", 29, 3900, 8, "cesar", "diretor123");
        Professor andre = new Professor("André Santana Nunes", 32, 2600, 6, "andre", "senha123");
        new Professor("Gabriel Agustin", 28, 2600, 4, "gabriel", "senha123");
        professores.add(andre);
        Aluno aluno1 = new Aluno("John Cena", 46, "johncena", "senha123");
        Aluno aluno2 = new Aluno("Oswald Martins", 81, "oswald", "senha123");
        Aluno aluno3 = new Aluno("Ana Pereira", 31, "anapereira", "senha123");
        Aluno aluno4 = new Aluno("Lucas Oliveira", 21, "lucasoliveira", "senha123");
        new Aluno("João Santos", 16, "joaosantos", "senha123");
        alunosTurma1.add(aluno1);
        alunosTurma1.add(aluno2);
        alunosTurma2.add(aluno1);
        alunosTurma2.add(aluno3);
        alunosTurma2.add(aluno4);
        Curso java = new Curso("Java", professores);
        Curso javaScript = new Curso("JavaScript", professores);
        new Turma(javaScript, 2024, alunosTurma1);
        new Turma(java, 2024, alunosTurma2);
        new Turma(java, 2025, alunosTurma1);
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

    public static Professor menuProfessor(Scanner entrada) {
        Professor professor;
        String nomeProfessor = login(entrada);
        if (nomeProfessor.equals("n")) { return null;}
        try {
            Professor professorEncontrado = DadosProfessores.getProfessorPorUsuario(nomeProfessor);
            String senha = pedirSenha(entrada);
            boolean senhaCorreta = professorEncontrado.getSenha().equals(senha);
            int limiteTentativas = 3;
            int tentativas = 0;
            while (!senhaCorreta) {
                tentativas++;
                if (tentativas > limiteTentativas) {
                    System.out.println("Limite de tentativas excedido.");
                    return null;
                }
                System.out.println("Senha inválida! Tentativas " + tentativas + "/" + limiteTentativas);
                senha = pedirSenha(entrada);
                senhaCorreta = professorEncontrado.getSenha().equals(senha);
            }
            professor = professorEncontrado;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return professor;
    }

    public static void menuFuncionario(Scanner entrada) {
        int opcao = Display.menuOpcoes(entrada, "Qual seu cargo?", new String[]{"Diretor", "Professor"});
        String opcaoSelecionada = tratarOpcoesFuncionarios(opcao);
        switch (opcaoSelecionada) {
            case "Diretor":
                Diretor diretor = menuDiretor(entrada);
                if (diretor == null) {
                    menuFuncionario(entrada);
                }
                Display.pagina(diretor);
                break;
            case "Professor":
                Professor professor = menuProfessor(entrada);
                if (professor == null) {
                    menuFuncionario(entrada);
                }
                Display.pagina(professor);
                break;
            case "Sair":
                System.out.println("voltando ao menu anterior....");
                return;
            default:
                System.out.println("opção invalida!");
        }
    }

    public static Diretor menuDiretor(Scanner entrada) {
        Diretor diretor;
        String nomeDiretor = login(entrada);
        if (nomeDiretor.equals("n")) { return null;}
        try {
            Diretor diretorEncontrado = DadosDiretores.getDiretorPorUsuario(nomeDiretor);
            System.out.print("Digite a senha: ");
            String senha = PedirEntrada.pedirString(entrada);
            if (diretorEncontrado.getSenha().equals(senha)) {
                diretor = diretorEncontrado;
            } else {
                throw new IllegalArgumentException("Senha inválida!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return diretor;
    }

    public static String trataritemSelecionadoMenu(int itemSelecionadoMenu) {
        if (itemSelecionadoMenu == 1) {
            return "Funcionário";
        } else if (itemSelecionadoMenu == 2) {
            return "Aluno";
        } else if (itemSelecionadoMenu == 0) {
            return "Sair";
        } else {
            return "Inválido";
        }
    }

    public static String tratarOpcoesFuncionarios(int opcao) {
        if (opcao == 1) {
            return "Diretor";
        } else if (opcao == 2) {
            return "Professor";
        } else if (opcao == 0) {
            return "Sair";
        } else {
            return "Inválido";
        }
    }
}