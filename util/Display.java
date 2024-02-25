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
        if (!definirAtributoConta(scan, aluno, transformarMetodo(aluno, "setNome", String.class), new String[]{"nome completo"})) {
            throw new RuntimeException("Criação de usuário cancelada");
        } else if (!definirAtributoConta(scan, aluno, transformarMetodo(aluno, "setIdade", int.class), new String[]{"idade"})) {
            throw new RuntimeException("Criação de usuário cancelada");
        } else if (!definirAtributoConta(scan, aluno, transformarMetodo(aluno, "setUsuario", String.class), new String[]{"usuário"})) {
            throw new RuntimeException("Criação de usuário cancelada");
        } else if (!definirAtributoConta(scan, aluno, transformarMetodo(aluno, "setSenha", String.class), new String[]{"senha"})) {
            throw new RuntimeException("Criação de usuário cancelada");
        }
        aluno.setStatusMatricula("ATIVO");
        DadosAlunos.adicionarAluno(aluno);

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
        } else if (!definirAtributoConta(scan, professor, transformarMetodo(classe, "setSalario", double.class), new String[]{"salario"})) {
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
        System.out.println("Salário: " + professor.getSalario());
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
        } else if (!definirAtributoConta(scan, diretor, transformarMetodo(classe, "setSalario", double.class), new String[]{"salario"})) {
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
        System.out.println("Salário: " + diretor.getSalario());
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
        List<Aluno> alunos = DadosAlunos.getAlunosCadastrados();
        List<Professor> professores = DadosProfessores.getProfessoresCadastrados();
        List<Diretor> diretores = DadosDiretores.getDiretoresCadastrados();

        LOOP:
        while (true) {
            switch (menuOpcoes(
                    scan,
                    "PÁGINA",
                    new String[]{"Cadastrar um novo professor", "Cadastrar um novo diretor", "Cadastrar um novo aluno",
                            "Promover um professor", "Promover um diretor",
                            "Excluir um professor", "Excluir um diretor", "Excluir um aluno",
                            "Listar todos os alunos com ID", "Listar todos os professores com ID", "Listar todos os diretores com ID",
                            "Adicionar aluno a turma", "Remover aluno da turma", "Adicionar professor a turma",
                            "Remover professor da turma", "listar todos os alunos da turma",
                            "Cadastrar turma", "Excluir turma", "Cadastrar curso", "Excluir curso",
                            "Listar todas as turmas", "Litar todos os crusos"}
            )) {
                case 1:
                    try {
                        System.out.println("Iniciando a criação de um Professor.");
                        Display.criarProfessor(scan, new Professor());
                    } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Iniciando a criação de um Diretor.");
                        Display.criarDiretor(scan, new Diretor());
                    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Iniciando a criação de um Aluno.");
                        Display.criarAluno(scan, new Aluno());
                    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    System.out.println("A lista de professores disponíveis para promoção são:");
                    for (Professor professor : professores) {
                        System.out.println(professor.getId() + " - " + professor.getNome() + " - " + professor.getNivelCargo());
                    }

                    System.out.println("Escolha o ID do Professor que deseja promover:");
                    int professorID = PedirEntrada.pedirInt(scan);
                    Professor professor1 = professores.get(professorID);

                    System.out.println("Escolha o tipo de promoção:");
                    switch (menuOpcoes(
                            scan,
                            "PROMOÇÃO",
                            new String[]{"Promoção apenas de cargo", "Promoção de cargo e salário"}
                    )) {
                        case 1:
                            professor1.promover();
                            System.out.println("O Professor " + professor1.getNome() + " foi promovido para o cargo " +
                                    professor1.getNivelCargo() + " com salário de " + professor1.getSalario());
                            break;
                        case 2:
                            System.out.println("Defina o valor adicional ao salário de " + professor1.getSalario());
                            professor1.promover(scan.nextDouble());
                            System.out.println("O Professor " + professor1.getNome() + " foi promovido para o cargo " +
                                    professor1.getNivelCargo() + " e o seu novo salário é " + professor1.getSalario());
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:
                    System.out.println("LISTA DE ALUNOS CADASTRADOS, COM ID.");
                    for (Aluno aluno : alunos) {
                        System.out.println(aluno.getId() + " - " + aluno.getNome());
                    }
                    break;
                case 10:
                    System.out.println("LISTA DE PROFESSORES CADASTRADOS, COM ID.");
                    for (Professor professor : professores) {
                        System.out.println(professor.getId() + " - " + professor.getNome());
                    }
                    break;
                case 11:
                    System.out.println("LISTA DE DIRETORES CADASTRADOS, COM ID.");
                    for (Diretor cadaDiretor : diretores) {
                        System.out.println(cadaDiretor.getId() + " - " + cadaDiretor.getNome());
                    }
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;
                case 17:
                    break;
                case 18:
                    break;
                case 19:
                    break;
                case 20:
                    break;
                case 21:
                    break;
                case 22:
                    break;
                case 0:
                    break LOOP;
            }
        }
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
                    new String[]{"Listar turma(s)", "Adicionar curso", "Remover curso", "Trancar/Ativar conta"}
            )) {
                case 1:
                    aluno.listarTurmasMatriculadas();
                    break;
                case 2:
                    List<Curso> cursos = DadosCursos.getCursosCadastrados();
                    List<String> cursosNome = new ArrayList<>();
                    for (Curso curso : cursos) {
                        cursosNome.add(curso.getNome());
                    }
                    menuOpcoes(
                            scan,
                            "Escolha o Curso que deseja entrar",
                            (String[]) cursosNome.toArray()
                    );
                    break;
                case 3:
                    break;
                case 4:
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
