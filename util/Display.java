package util;

import dados.*;
import objetos.Aluno;
import objetos.Curso;
import objetos.Turma;
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
        Aluno alunoCopia = new Aluno();
        if (!definirAtributoConta(scan, alunoCopia, transformarMetodo(alunoCopia, "setNome", String.class), new String[]{"nome completo"})) {
            throw new RuntimeException("Criação de usuário cancelada");
        } else if (!definirAtributoConta(scan, alunoCopia, transformarMetodo(alunoCopia, "setIdade", int.class), new String[]{"idade"})) {
            throw new RuntimeException("Criação de usuário cancelada");
        } else if (!definirAtributoConta(scan, alunoCopia, transformarMetodo(alunoCopia, "setUsuario", String.class), new String[]{"usuário"})) {
            throw new RuntimeException("Criação de usuário cancelada");
        } else if (!definirAtributoConta(scan, alunoCopia, transformarMetodo(alunoCopia, "setSenha", String.class), new String[]{"senha"})) {
            throw new RuntimeException("Criação de usuário cancelada");
        }
        aluno.setNome(alunoCopia.getNome());
        aluno.setIdade(alunoCopia.getIdade());
        aluno.setUsuario(alunoCopia.getUsuario());
        aluno.setSenha(alunoCopia.getSenha());
        try {
            DadosAlunos.getAlunoPorUsuario(aluno.getUsuario());
        } catch (IllegalArgumentException e) {
            aluno.setStatusMatricula("ATIVO");
            DadosAlunos.adicionarAluno(aluno);
        }

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
        return classe.getDeclaredMethod(nomeMetodo, parametros);
    }

    public static Method transformarMetodo(Object objeto, String nomeMetodo, Class<?>... parametros) throws NoSuchMethodException {
        return objeto.getClass().getDeclaredMethod(nomeMetodo, parametros);
    }

    public static boolean definirAtributoConta(Scanner scan, Object objeto, Method metodo, String[] parametrosNome) throws InvocationTargetException, IllegalAccessException {
        while (true) {
            Class<?>[] parametrosTipos = metodo.getParameterTypes();
            Object[] argumentos = new Object[parametrosTipos.length];

            for (int i = 0; i < parametrosTipos.length; i++) {
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
                metodo.invoke(objeto, argumentos);
            } catch (Exception e) {
                System.out.println(e.getCause().getMessage()); // Exibe mensagem
                System.out.println("Entrada(s) inválida(s).");

                System.out.println("Quer continuar? [s]im / [n]ão");
                if (!PedirEntrada.pedirBoolean(scan)) {
                    return false;
                }
                continue;
            }

            System.out.println("Quer continuar? [s]im / [n]ão");
            return PedirEntrada.pedirBoolean(scan);
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

        System.out.println("\n"+ textoCharRepetido(titulo.length()));

        System.out.println(formatarCentroString(titulo, 44));

        System.out.println(textoCharRepetido(titulo.length()));

        for (int i = 0; i < opcoes.length; i++) {
            System.out.println("[" + (i + 1) + "] " + opcoes[i]);
        }
        System.out.println("[0] SAIR");

        System.out.println(textoCharRepetido(titulo.length()));

        System.out.print("Por favor, informe qual opção você deseja interagir: ");
        return PedirEntrada.pedirInt(scan);
    }

    public static void pagina(Diretor diretor) {
        Scanner scan = new Scanner(System.in);
        menuOpcoes(scan, "Listar", null);
    }

    public static void pagina(Professor professor) {

    }

    public static void pagina(Aluno aluno) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Scanner scan = new Scanner(System.in);
        LOOP:
        while (true) {
            String[] opcoes;
            if (aluno.getStatusMatricula().toString().equals("ATIVO")) {
                opcoes = new String[]{"Visualizar dados", "Listar turma(s)", "Entrar na turma", "Sair da turma", "Trancar/Ativar conta"};
            } else {
                opcoes = new String[]{"Visualizar dados", "Listar turma(s)", "Trancar/Ativar conta"};
            }
            int escolha = menuOpcoes(
                    scan,
                    "PÁGINA",
                    opcoes
            );
            if (escolha > opcoes.length) {
                continue;
            }
            String escolhaString = "0";
            if (escolha > 0) {
                escolhaString = opcoes[escolha-1];
            }
            switch (escolhaString) {
                case "Visualizar dados":
                    System.out.println();
                    System.out.println("Nome: "+ aluno.getNome());
                    System.out.println("Idade: "+ aluno.getIdade());
                    System.out.println("Usuário: "+ aluno.getUsuario());
                    System.out.println("Senha: "+ aluno.getSenha());
                    System.out.println("Status da matrícula: "+ aluno.getStatusMatricula());
                    System.out.println("Quer editar seus dados? [s]im / [n]ão");
                    if (PedirEntrada.pedirBoolean(scan)) {
                        try {
                            criarAluno(scan, aluno);
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Listar turma(s)":
                    System.out.println();
                    aluno.listarTurmasMatriculadas();
                    break;
                case "Entrar na turma": {
                    System.out.println();
                    List<Curso> cursos = new ArrayList<>(DadosCursos.getCursosCadastrados());
                    String[] cursosDisplay = new String[cursos.size()];
                    for (int i = 0; i < cursos.size(); i++) {
                        cursosDisplay[i] = cursos.get(i).getNome();
                    }

                    int opcaoCurso = menuOpcoes(
                            scan,
                            "Escolha o Curso que deseja entrar",
                            cursosDisplay
                    );
                    if (opcaoCurso == 0 || opcaoCurso > cursosDisplay.length) {
                        continue;
                    } else {
                        Curso curso = cursos.get(opcaoCurso - 1);

                        List<Turma> turmas = new ArrayList<>(curso.getTurmas());
                        turmas.removeIf(turma -> aluno.getTurmas().contains(turma));

                        String[] turmasDisplay = new String[turmas.size()];
                        for (int i = 0; i < turmas.size(); i++) {
                            Turma turma = turmas.get(i);
                            turmasDisplay[i] = turma.toString();
                        }

                        int opcaoTurma = menuOpcoes(
                                scan,
                                "Escolha a Turma de " + cursosDisplay[opcaoCurso - 1] + " que deseja entrar",
                                turmasDisplay
                        );
                        try {
                            turmas.get(opcaoTurma - 1).adicionarAluno(aluno);
                            System.out.println("Entrou na turma com sucesso!");
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                }
                    break;
                case "Sair da turma": {
                    System.out.println();
                    List<Curso> cursos = new ArrayList<>(DadosCursos.getCursosCadastrados());
                    cursos.removeIf(curso -> curso.getTurmas().removeIf(turma -> !aluno.getTurmas().contains(turma)));
                    String[] cursosDisplay = new String[cursos.size()];
                    for (int i = 0; i < cursos.size(); i++) {
                        cursosDisplay[i] = cursos.get(i).getNome();
                    }

                    int opcaoCurso = menuOpcoes(
                            scan,
                            "Escolha o Curso da turma que deseja sair",
                            cursosDisplay
                    );
                    if (opcaoCurso == 0 || opcaoCurso > cursosDisplay.length) {
                        continue;
                    } else {
                        Curso curso = cursos.get(opcaoCurso - 1);

                        List<Turma> turmas = new ArrayList<>(curso.getTurmas());
                        turmas.removeIf(turma -> !aluno.getTurmas().contains(turma));

                        String[] turmasDisplay = new String[turmas.size()];
                        for (int i = 0; i < turmas.size(); i++) {
                            Turma turma = turmas.get(i);
                            turmasDisplay[i] = turma.toString();
                        }

                        int opcaoTurma = menuOpcoes(
                                scan,
                                "Escolha a Turma de " + cursosDisplay[opcaoCurso - 1] + " que deseja sair",
                                turmasDisplay
                        );
                        try {
                            turmas.get(opcaoTurma - 1).removerAluno(aluno);
                            System.out.println("Saiu da turma com sucesso!");
                        } catch (IndexOutOfBoundsException e) {
                            break;
                        }
                    }
                }
                    break;
                case "Trancar/Ativar conta":
                    System.out.println();
                    System.out.println("O Status da sua matricula é " + aluno.getStatusMatricula());
                    String trancarOuAtivar;
                    if (aluno.getStatusMatricula().toString().equals("ATIVO")) {
                        trancarOuAtivar = "TRANCAR";
                    } else {
                        trancarOuAtivar = "ATIVAR";
                    }
                    System.out.println("Tem certeza que deseja " + trancarOuAtivar + " a sua matrícula? [s]im / [n]ão");
                    if (!PedirEntrada.pedirBoolean(scan)) {
                        break;
                    }
                    try {
                        aluno.trancarAtivarCadastro();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Tente criar uma nova conta ou entre em contato com o suporte para ativar sua conta.");
                    }
                    break;
                case "0":
                    break LOOP;
            }
        }
    }

    public static String formatarCentroString(String texto, int tamanho) {
        if (texto.length() > tamanho) {
            tamanho = texto.length();
        }
        StringBuilder sb = new StringBuilder(tamanho);
        sb.setLength((tamanho - texto.length()) / 2);
        sb.append(texto);
        sb.setLength(tamanho);
        return sb.toString().replace('\0', ' ');
    }

    public static String textoCharRepetido(int tamanho) {
        if (tamanho < 44) {
            tamanho = 44;
        }
        StringBuilder sb = new StringBuilder(tamanho);
        sb.setLength(tamanho);
        return sb.toString().replace('\0', '█');
    }
}
