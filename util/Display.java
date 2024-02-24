package util;

import dados.DadosAlunos;
import dados.DadosDiretores;
import dados.DadosProfessores;
import objetos.Aluno;
import objetos.funcionarios.Diretor;
import objetos.funcionarios.Funcionario;
import objetos.funcionarios.Professor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Display {

    public static void criarAluno(Scanner scan, Aluno aluno) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        boolean continuar = true;
        if (!definirAtributoConta(scan, aluno, transformarMetodo(aluno, "setNome", String.class), new String[]{"nome completo"})) {
            continuar = false;
        } else if (!definirAtributoConta(scan, aluno, transformarMetodo(aluno, "setIdade", int.class), new String[]{"idade"})) {
            continuar = false;
        } else if (!definirAtributoConta(scan, aluno, transformarMetodo(aluno, "setUsuario", String.class), new String[]{"usuário"})) {
            continuar = false;
        } else if (!definirAtributoConta(scan, aluno, transformarMetodo(aluno, "setSenha", String.class), new String[]{"senha"})) {
            continuar = false;
        }
        if (continuar) {
            aluno.setStatusMatricula("ATIVO");
            DadosAlunos.adicionarAluno(aluno);
        }
        System.out.println("Continuar: " + continuar);
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println("Usuario: " + aluno.getUsuario());
        System.out.println("Senha: " + aluno.getSenha());
        System.out.println();
    }

    public static void criarProfessor(Scanner scan, Professor professor) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        boolean continuar = true;
        Class<Funcionario> classe = Funcionario.class;
        if (!definirAtributoConta(scan, professor, transformarMetodo(classe, "setNome", String.class), new String[]{"nome completo"})) {
            continuar = false;
        } else if (!definirAtributoConta(scan, professor, transformarMetodo(classe, "setIdade", int.class), new String[]{"idade"})) {
            continuar = false;
        } else if (!definirAtributoConta(scan, professor, transformarMetodo(classe, "setUsuario", String.class), new String[]{"usuário"})) {
            continuar = false;
        } else if (!definirAtributoConta(scan, professor, transformarMetodo(classe, "setSenha", String.class), new String[]{"senha"})) {
            continuar = false;
        }
        if (continuar) {
            professor.setNivelCargo("INICIANTE");
            DadosProfessores.adicionarProfessor(professor);
        }
        System.out.println("Continuar: " + continuar);
        System.out.println("Nome: " + professor.getNome());
        System.out.println("Idade: " + professor.getIdade());
        System.out.println("Usuario: " + professor.getUsuario());
        System.out.println("Senha: " + professor.getSenha());
        System.out.println();
    }

    public static void criarDiretor(Scanner scan, Diretor diretor) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        boolean continuar = true;
        Class<Funcionario> classe = Funcionario.class;
        if (!definirAtributoConta(scan, diretor, transformarMetodo(classe, "setNome", String.class), new String[]{"nome completo"})) {
            continuar = false;
        } else if (!definirAtributoConta(scan, diretor, transformarMetodo(classe, "setIdade", int.class), new String[]{"idade"})) {
            continuar = false;
        } else if (!definirAtributoConta(scan, diretor, transformarMetodo(classe, "setUsuario", String.class), new String[]{"usuário"})) {
            continuar = false;
        } else if (!definirAtributoConta(scan, diretor, transformarMetodo(classe, "setSenha", String.class), new String[]{"senha"})) {
            continuar = false;
        }
        if (continuar) {
            diretor.setNivelCargo("INICIANTE");
            DadosDiretores.adicionarDiretor(diretor);
        }
        System.out.println("Continuar: " + continuar);
        System.out.println("Nome: " + diretor.getNome());
        System.out.println("Idade: " + diretor.getIdade());
        System.out.println("Usuario: " + diretor.getUsuario());
        System.out.println("Senha: " + diretor.getSenha());
        System.out.println();
    }

    public static Method transformarMetodo(Class<?> classe, String nomeMetodo, Class<?>... parametros) throws NoSuchMethodException {
//        Pega a classe, e pesquisa o método pelo nome
        return classe.getDeclaredMethod(nomeMetodo, parametros);
    }

    public static Method transformarMetodo(Object objeto, String nomeMetodo, Class<?>... parametros) throws NoSuchMethodException {
//        Pega a classe do objeto, e pesquisa o método pelo nome
        return objeto.getClass().getDeclaredMethod(nomeMetodo, parametros);
    }

    public static boolean definirAtributoConta(Scanner scan, Object objeto, Method metodo, String[] parametrosNome) throws InvocationTargetException, IllegalAccessException {

        while (true) {
            Class<?>[] parametrosTipos = metodo.getParameterTypes();
            Object[] argumentos = new Object[parametrosTipos.length];

            for (int i = 0; i < parametrosTipos.length; i++) {
//                Verifica cada parâmetro, e pede a entrada do tipo daquele parâmetro
//                Armazena as entradas em argumentos[]
                System.out.print("Digite seu/sua " + parametrosNome[i] + ": ");
                if (parametrosTipos[i].equals(String.class)) {
                    argumentos[i] = PedirEntrada.pedirString(scan);
                } else if (parametrosTipos[i].equals(char.class)) {
                    argumentos[i] = PedirEntrada.pedirChar(scan);
                } else if (parametrosTipos[i].equals(boolean.class)) {
                    argumentos[i] = PedirEntrada.pedirBoolean(scan);
                } else if (parametrosTipos[i].equals(byte.class)) {
                    argumentos[i] = PedirEntrada.pedirByte(scan);
                } else if (parametrosTipos[i].equals(short.class)) {
                    argumentos[i] = PedirEntrada.pedirShort(scan);
                } else if (parametrosTipos[i].equals(int.class)) {
                    argumentos[i] = PedirEntrada.pedirInt(scan);
                } else if (parametrosTipos[i].equals(long.class)) {
                    argumentos[i] = PedirEntrada.pedirLong(scan);
                } else if (parametrosTipos[i].equals(float.class)) {
                    argumentos[i] = PedirEntrada.pedirFloat(scan);
                } else if (parametrosTipos[i].equals(double.class)) {
                    argumentos[i] = PedirEntrada.pedirDouble(scan);
                }
            }
            try {
                metodo.invoke(objeto, argumentos); // Chama o método
            } catch (Exception e) {
//                Tratamento de erro, caso a entrada não satisfaça as condições
                System.out.println(e.getCause().getMessage()); // Exibe mensagem
                System.out.println("Entrada(s) inválida(s).");

                System.out.println("Quer continuar? [s]im / [n]ão");
                if (!PedirEntrada.pedirBoolean(scan)) {
                    return false;
                }
                continue;
            }

//            Se der certo, pergunta se quer continuar
            System.out.println("Quer continuar? [s]im / [n]ão");
            return PedirEntrada.pedirBoolean(scan); // retorna o boolean do scan
        }
    }

    public static void exibirLista(List<?> lista, Method... metodos) throws InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(i + " - ");
            for (Method metodo : metodos) {
                System.out.print(metodo.invoke(lista.get(i)));
            }
            System.out.println();
        }
    }

    public static int menuOpcoes(Scanner scan, String titulo, String[] opcoes) {
        System.out.println("\n████████████████████████████████████████████");
        System.out.println(formatarCentroString(titulo, 44));
        System.out.println("████████████████████████████████████████████");
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println("[" + (i + 1) + "] " + opcoes[i]);
        }
        System.out.println("[0] SAIR");
        System.out.println("████████████████████████████████████████████");
        System.out.print("Por favor, informe qual opção você deseja interagir: ");
        return PedirEntrada.pedirInt(scan);
    }

    public static void pagina(Diretor diretor) {
        Scanner scan = new Scanner(System.in);
        menuOpcoes(scan, "Listar", null);
    }

    public static void pagina(Professor professor) {

    }

    public static void pagina(Aluno aluno) {
        Scanner scan = new Scanner(System.in);
        LOOP:
        while (true) {
            switch (menuOpcoes(
                    scan,
                    "PÁGINA",
                    new String[]{"Listar curso(s)", "Adicionar curso", "Remover curso", "Trancar/Ativar conta"}
            )) {
                case 1:
                    // TODO: Esperar PR da Pâmela para listar cursos do aluno
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("O Status da sua matricula é " + aluno.getStatusMatricula());
                    String trancarOuAtivar;
                    if (aluno.getStatusMatricula().toString().equals("TRANCADO")) {
                        trancarOuAtivar = "ATIVAR";
                    } else {
                        trancarOuAtivar = "TRANCAR";
                    }
                    System.out.println("Tem certeza que deseja " + trancarOuAtivar + " a sua matrícula? [s]im / [n]ão");
                    if (!PedirEntrada.pedirBoolean(scan)) {
                        break;
                    }
                    if (trancarOuAtivar.equals("TRANCAR")) {
                        aluno.setStatusMatricula("TRANCADO");
                        System.out.println("Conta TRANCADA com sucesso!");
                    } else {
                        aluno.setStatusMatricula("ATIVO");
                        System.out.println("Conta ATIVADA com sucesso!");
                    }
                    break;
                case 0:
                    break LOOP;
            }
        }
    }

    public static String formatarCentroString(String texto, int tamanho) {
        StringBuilder sb = new StringBuilder(tamanho);
        sb.setLength((tamanho - texto.length()) / 2);
        sb.append(texto);
        sb.setLength(tamanho);
        return sb.toString().replace('\0', ' ');
    }
}
