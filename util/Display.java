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
        } else if (!definirAtributoConta(scan, professor, transformarMetodo(classe, "setSalario", double.class), new String[]{"salario"})) {
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
        } else if (!definirAtributoConta(scan, diretor, transformarMetodo(classe, "setUsuario", String.class), new String[]{"usuário"})) {
            continuar = false;
        } else if (!definirAtributoConta(scan, diretor, transformarMetodo(classe, "setSenha", String.class), new String[]{"senha"})) {
            continuar = false;
        } else if (!definirAtributoConta(scan, diretor, transformarMetodo(classe, "setSalario", double.class), new String[]{"salario"})) {
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

    public static void exibirLista(ArrayList<?> lista, Method... metodos) throws InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(i + " - ");
            for (Method metodo : metodos) {
                System.out.print(metodo.invoke(lista.get(i)));
            }
            System.out.println();
        }
    }

    public static int menuOpcoes(Scanner scan, String titulo, String[] opcoes) {
        System.out.println("\n" + textoCharRepetido(titulo.length()));

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

    public static void pagina(Diretor usuario) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Scanner scan = new Scanner(System.in);
        List<Aluno> alunos = DadosAlunos.getAlunosCadastrados();
        List<Professor> professores = DadosProfessores.getProfessoresCadastrados();
        List<Diretor> diretores = DadosDiretores.getDiretoresCadastrados();
        List<Curso> cursos = DadosCursos.getCursosCadastrados();

        LOOP:
        while (true) {
            switch (menuOpcoes(
                    scan,
                    "PÁGINA",
                    new String[]{
                            "Cadastrar um novo professor", "Cadastrar um novo diretor", "Cadastrar um novo aluno",
                            "Promover um professor", "Promover um diretor",
                            "Excluir um professor", "Excluir um diretor", "Excluir um aluno",
                            "Listar todos os alunos", "Listar todos os professores", "Listar todos os diretores",
                            "Adicionar aluno a turma", "Remover aluno da turma",
                            "Adicionar professor ao curso", "Remover professor do curso",
                            "Listar todos os alunos da turma",
                            "Cadastrar turma", "Excluir turma", "Cadastrar curso", "Excluir curso",
                            "Listar todas as turmas", "Listar todos os cursos", "Visualizar dados"
                    }
            )) {
                case 1:
                    try {
                        System.out.println("Iniciando a criação de um Professor.");
                        Display.criarProfessor(scan, new Professor());
                    } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
                        System.out.println("Não foi possível cadastrar o professor.");
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Iniciando a criação de um Diretor.");
                        Display.criarDiretor(scan, new Diretor());
                    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                        System.out.println("Não foi possível cadastrar o diretor.");
                        throw new RuntimeException(e);
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Iniciando a criação de um Aluno.");
                        Display.criarAluno(scan, new Aluno());
                    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                        System.out.println("Não foi possível cadastrar o aluno.");
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    DadosProfessores.imprimirListaTodosProfessores();
                    System.out.println();
                    System.out.print("Escolha o ID do Professor que deseja promover: ");
                    int professorID = PedirEntrada.pedirInt(scan);
                    Professor professorPromovido = professores.get(professorID);
                    System.out.println("Escolha o tipo de promoção");
                    switch (menuOpcoes(
                            scan,
                            "PROMOÇÃO",
                            new String[]{"Promoção apenas de cargo", "Promoção de cargo e salário"}
                    )) {
                        case 1:
                            try {
                                professorPromovido.promover();
                                System.out.println(
                                        "O Professor " + professorPromovido.getNome() +
                                        " foi promovido para o nível " + professorPromovido.getNivelCargo() +
                                        " com salário de R$" + professorPromovido.getSalario()
                                );
                            } catch (Exception e) {
                                System.out.println("Não foi possível promover o professor.");
                                throw new RuntimeException(e);
                            }
                            break;
                        case 2:
                            try {
                                System.out.print("Defina o valor a ser adicionado ao salário do professor: ");
                                professorPromovido.promover(PedirEntrada.pedirDouble(scan));
                                System.out.println(
                                        "O Professor " + professorPromovido.getNome() +
                                        " foi promovido para o nível " + professorPromovido.getNivelCargo() +
                                        " e o seu novo salário é R$" + professorPromovido.getSalario()
                                );
                            } catch (Exception e) {
                                System.out.println("Não foi possível promover o professor.");
                                throw new RuntimeException(e);
                            }
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 5:
                    DadosDiretores.imprimirListaTodosDiretores();
                    int diretorID;
                    Diretor diretorPromovido = new Diretor();
                    boolean usuarioEhDiretorPromovido = true;
                    System.out.println();
                    while (usuarioEhDiretorPromovido) {
                        System.out.print("Escolha o ID do diretor que deseja promover: ");
                        diretorID = PedirEntrada.pedirInt(scan);
                        diretorPromovido = diretores.get(diretorID);
                        usuarioEhDiretorPromovido = diretorID == usuario.getId();
                        if (usuarioEhDiretorPromovido) { System.out.println("Você não pode se auto promover"); }
                    }
                    System.out.println("Escolha o tipo de promoção");
                    switch (menuOpcoes(
                            scan,
                            "PROMOÇÃO",
                            new String[]{"Promoção apenas de cargo", "Promoção de cargo e salário"}
                    )) {
                        case 1:
                            try {
                                diretorPromovido.promover();
                                System.out.println(
                                        "O Diretor " + diretorPromovido.getNome() +
                                        " foi promovido para o nível " + diretorPromovido.getNivelCargo() +
                                        " com salário de R$" + diretorPromovido.getSalario()
                                );
                            } catch (Exception e) {
                                System.out.println("Não foi possível promover o diretor.");
                                throw new RuntimeException(e);
                            }
                            break;
                        case 2:
                            try {
                                System.out.print("Defina o valor a ser adicionado ao salário do diretor: ");
                                diretorPromovido.promover(PedirEntrada.pedirDouble(scan));
                                System.out.println(
                                        "O Diretor " + diretorPromovido.getNome() +
                                        " foi promovido para o nível " + diretorPromovido.getNivelCargo() +
                                        " e o seu novo salário é R$" + diretorPromovido.getSalario()
                                );
                            } catch (Exception e) {
                                System.out.println("Não foi possível promover o diretor.");
                                throw new RuntimeException(e);
                            }
                            break;
                        case 0:
                            break;
                    }
                    break;
                case 6:
                    DadosProfessores.imprimirListaTodosProfessores();
                    System.out.print("\nInforme o ID do professor que deseja excluir o cadastro.");
                    int idProfessorExcluido = PedirEntrada.pedirInt(scan);
                    try {
                        DadosProfessores.removerProfessorPorId(idProfessorExcluido);
                    } catch (Exception e) {
                        System.out.println("Não foi possível excluir o professor.");
                        throw new RuntimeException(e);
                    }
                    break;
                case 7:
                    DadosDiretores.imprimirListaTodosDiretores();
                    System.out.print("\nInforme o ID do diretor que deseja excluir o cadastro.");
                    int idDiretorExcluido = PedirEntrada.pedirInt(scan);
                    try {
                        DadosDiretores.removerDiretorPorId(idDiretorExcluido);
                    } catch (Exception e) {
                        System.out.println("Não foi possível excluir o diretor.");
                        throw new RuntimeException(e);
                    }
                    break;
                case 8:
                    DadosAlunos.imprimirListaTodosAlunos();
                    System.out.print("\nInforme o ID do aluno que deseja excluir o cadastro.");
                    int idAlunoExcluido = PedirEntrada.pedirInt(scan);
                    try {
                        DadosAlunos.removerAlunoPorId(idAlunoExcluido);
                    } catch (Exception e) {
                        System.out.println("Não foi possível excluir o aluno.");
                        throw new RuntimeException(e);
                    }
                    break;
                case 9:
                    System.out.println("LISTA DE ALUNOS CADASTRADOS, COM ID.");
                    DadosAlunos.imprimirListaTodosAlunos();
                    break;
                case 10:
                    System.out.println("LISTA DE PROFESSORES CADASTRADOS, COM ID.");
                    DadosProfessores.imprimirListaTodosProfessores();
                    break;
                case 11:
                    System.out.println("LISTA DE DIRETORES CADASTRADOS, COM ID.");
                    DadosDiretores.imprimirListaTodosDiretores();
                    break;
                case 12:
                    System.out.println("\nSegue turmas disponíveis");
                    DadosTurmas.listarTurmasCadastradas();
                    System.out.print("\nInforme o ID da turma que deseja incluir o aluno: ");
                    int turmaId = PedirEntrada.pedirInt(scan);
                    try {
                        Turma turma = DadosTurmas.getTurmasCadastradas().get(turmaId);
                        System.out.print("Informe o usuário do aluno que deseja incluir na turma: ");
                        String usuarioAluno = PedirEntrada.pedirString(scan);
                        Aluno aluno = DadosAlunos.getAlunoPorUsuario(usuarioAluno);
                        turma.adicionarAluno(aluno);
                        System.out.println("Aluno adicionado com sucesso.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Não foi possível adicionar aluno a turma.");
                    }
                    break;
                case 13:
                    System.out.println("\nSegue turmas disponíveis");
                    DadosTurmas.listarTurmasCadastradas();
                    System.out.print("\nInforme o ID da turma que deseja remover o aluno: ");
                    int idTurma = PedirEntrada.pedirInt(scan);
                    try {
                        Turma turma = DadosTurmas.getTurmasCadastradas().get(idTurma);
                        System.out.print("Informe o usuário do aluno que remover da turma: ");
                        String usuarioAlunoRemovido = PedirEntrada.pedirString(scan);
                        Aluno alunoRemovido = DadosAlunos.getAlunoPorUsuario(usuarioAlunoRemovido);
                        turma.removerAluno(alunoRemovido);
                        System.out.println("Aluno removido com sucesso.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Não foi possível adicionar aluno a turma.");
                    }
                    break;
                case 14:
                    System.out.println("\nSegue cursos disponíveis");
                    DadosCursos.listarCursosCadastrados();
                    System.out.print("\nInforme o ID do curso que deseja incluir o professor: ");
                    int idCurso = PedirEntrada.pedirInt(scan);
                    try {
                        Curso curso = DadosCursos.getCursosCadastrados().get(idCurso);
                        System.out.print("Informe o usuário do professor que deseja incluir no curso: ");
                        String usuarioProfessor = PedirEntrada.pedirString(scan);
                        Professor novoProfessor = DadosProfessores.getProfessorPorUsuario(usuarioProfessor);
                        curso.adicionaProfessor(novoProfessor);
                        System.out.println("Professor adicionado com sucesso.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Não foi possível adicionar o professor ao curso.");
                    }
                    break;
                case 15:
                    System.out.println("\nSegue cursos disponíveis");
                    DadosCursos.listarCursosCadastrados();
                    System.out.print("\nInforme o ID do curso que deseja remover o professor: ");
                    int cursoId = PedirEntrada.pedirInt(scan);
                    try {
                        Curso curso = DadosCursos.getCursosCadastrados().get(cursoId);
                        System.out.print("Informe o usuário do professor que deseja remover do curso: ");
                        String usuarioProfessor = PedirEntrada.pedirString(scan);
                        Professor novoProfessor = DadosProfessores.getProfessorPorUsuario(usuarioProfessor);
                        curso.removerProfessor(novoProfessor);
                        System.out.println("Professor removido com sucesso.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Não foi possível remover o professor do curso.");
                    }
                    break;
                case 16:
                    System.out.println("\nSegue turmas disponíveis");
                    DadosTurmas.listarTurmasCadastradas();
                    System.out.print("\nInforme o ID da turma que deseja ver os aluno: ");
                    int idTurmaSelecionada = PedirEntrada.pedirInt(scan);
                    try {
                        Turma turma = DadosTurmas.getTurmasCadastradas().get(idTurmaSelecionada);
                        turma.imprimirListaAlunos();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Não foi possível listar os alunos da turma.");
                    }
                    break;
                case 17:
                    System.out.println("\nIniciando a criação de turma.");
                    break;
                case 18:
                    DadosTurmas.listarTurmasCadastradas();
                    System.out.println("Escolha o ID da Turma a ser removido:");
                    try {
                        DadosTurmas.removerTurma(DadosTurmas.getTurmaPorId(PedirEntrada.pedirInt(scan)));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Não é possível excluir turma inexistente.");
                    }
                    break;
                case 19:
                    Curso curso = new Curso();

                    try {
                        System.out.println("\nIniciando a criação de curso.");
                        System.out.println("Digite o nome do novo curso:");
                        String nomeCurso = PedirEntrada.pedirString(scan);
                        if (!DadosCursos.getCursosCadastrados().contains(nomeCurso)) {
                            curso.setNome(nomeCurso);

                            DadosProfessores.imprimirListaTodosProfessores();

                            LOOPCurso:
                            while (true) {
                                System.out.println("Para adicionar o professor ao curso, digite o seu ID");
                                curso.adicionaProfessor(DadosProfessores.getProfessorPorId(PedirEntrada.pedirInt(scan)));

                                System.out.println("Deseja adicionar mais professores?");
                                System.out.println("[s]im / [n]ão.");
                                if (!PedirEntrada.pedirBoolean(scan)) {
                                    break LOOPCurso;
                                }
                            }

                            DadosCursos.adicionarCurso(curso);

                        } else {
                            System.out.println("Curso existente.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Não foi possível criar o curso.");
                    }
                    break;
                case 20:
                    DadosCursos.listarCursosCadastrados();
                    System.out.println("Escolha o ID do Curso a ser removido:");
                    try {
                        DadosCursos.removerCurso(DadosCursos.getCursoPorId(PedirEntrada.pedirInt(scan)));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Não é possível excluir curso inexistente.");
                    }
                    break;
                case 21:
                    DadosTurmas.listarTurmasCadastradas();
                    break;
                case 22:
                    DadosCursos.listarCursosCadastrados();
                    break;
                case 23:
                    System.out.println();
                    System.out.println("Nome: "+ usuario.getNome());
                    System.out.println("Idade: "+ usuario.getIdade());
                    System.out.println("Usuário: "+ usuario.getUsuario());
                    System.out.println("Senha: "+ usuario.getSenha());
                    System.out.println("Salário: "+ usuario.getSalario());
                    System.out.println("Nível do Cargo: "+ usuario.getNivelCargo());
                    System.out.println("Anos nesse Cargo: "+ usuario.getAnosCargo());
                    System.out.println("Quer editar seus dados? [s]im / [n]ão");
                    if (PedirEntrada.pedirBoolean(scan)) {
                        try {
                            criarDiretor(scan, usuario);
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saindo de sua conta....");
                    break LOOP;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void pagina(Professor professor) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Scanner scan = new Scanner(System.in);
        Aluno aluno;
        String usuarioAluno;
        int turmaId;
        LOOP:
        while (true) {
            switch (menuOpcoes(
                    scan,
                    "PÁGINA",
                    new String[]{
                            "Listar alunos",
                            "Adicionar aluno a uma turma",
                            "Remover aluno de uma turma",
                            "Formar aluno",
                            "Visualizar dados"
                    }
            )) {
                case 1:
                    try {
                        System.out.println();
                        professor.listarAlunoCursoTurma();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Não foi possível listar alunos.");
                    }
                    break;
                case 2: {
                    System.out.println();
                    System.out.println("Segue turmas disponíveis");
                    ArrayList<Turma> turmas = professor.getTurmas();
                    String[] turmasNome = new String[turmas.size()];
                    for (int i = 0; i < turmas.size(); i++) {
                        turmasNome[i] = turmas.get(i).toString();
                    }
                    int opcao = menuOpcoes(scan, "Selecione a turma em que deseja adicionar o aluno", turmasNome);
                    if (opcao <= 0) {
                        continue;
                    }
                    if (opcao > turmas.size()) {
                        break;
                    }
                    turmaId = turmas.get(opcao - 1).getID();
//                    DadosTurmas.listarTurmasCadastradas();
//                    System.out.println();
//                    System.out.print("Informe o ID da turma que deseja incluir o aluno: ");
//                    turmaId = PedirEntrada.pedirInt(scan);
                    try {
                        Turma turma = DadosTurmas.getTurmasCadastradas().get(turmaId);
                        System.out.print("Informe o usuário do aluno para incluir à turma: ");
                        usuarioAluno = PedirEntrada.pedirString(scan);
                        aluno = DadosAlunos.getAlunoPorUsuario(usuarioAluno);
                        turma.adicionarAluno(aluno);
                        System.out.println("Aluno adicionado com sucesso.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Não foi possível adicionar aluno à turma.");
                    }
                    break;
                }
                case 3: {
                    System.out.println();
                    System.out.println("Segue turmas disponíveis");
                    ArrayList<Turma> turmas = professor.getTurmas();
                    String[] turmasNome = new String[turmas.size()];
                    for (int i = 0; i < turmas.size(); i++) {
                        turmasNome[i] = turmas.get(i).toString();
                    }
                    int opcao = menuOpcoes(scan, "Selecione a turma em que deseja remover o aluno", turmasNome);
                    if (opcao <= 0) {
                        continue;
                    }
                    if (opcao > turmas.size()) {
                        break;
                    }
                    turmaId = turmas.get(opcao - 1).getID();
//                    DadosTurmas.listarTurmasCadastradas();
//                    System.out.println();
//                    System.out.print("Informe o ID da turma que deseja remover o aluno: ");
//                    turmaId = PedirEntrada.pedirInt(scan);
                    try {
                        Turma turma = DadosTurmas.getTurmasCadastradas().get(turmaId);
                        System.out.print("Informe o usuário do aluno para remover da turma: ");
                        usuarioAluno = PedirEntrada.pedirString(scan);
                        aluno = DadosAlunos.getAlunoPorUsuario(usuarioAluno);
                        turma.removerAluno(aluno);
                        System.out.println("Aluno removido com sucesso.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Não foi possível remover aluno da turma.");
                    }
                    break;
                }
                case 4: {
                    System.out.print("Informe o usuário do aluno que deseja formar: ");
                    usuarioAluno = PedirEntrada.pedirString(scan);
                    try {
                        aluno = DadosAlunos.getAlunoPorUsuario(usuarioAluno);
                        aluno.formar();
                        System.out.println(aluno);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Não foi possível formar o aluno.");
                    }
                    break;
                }
                case 5:
                    System.out.println();
                    System.out.println("Nome: "+ professor.getNome());
                    System.out.println("Idade: "+ professor.getIdade());
                    System.out.println("Usuário: "+ professor.getUsuario());
                    System.out.println("Senha: "+ professor.getSenha());
                    System.out.println("Salário: "+ professor.getSalario());
                    System.out.println("Nível do Cargo: "+ professor.getNivelCargo());
                    System.out.println("Anos nesse Cargo: "+ professor.getAnosCargo());
                    System.out.println("Quer editar seus dados? [s]im / [n]ão");
                    if (PedirEntrada.pedirBoolean(scan)) {
                        try {
                            criarProfessor(scan, professor);
                        } catch (RuntimeException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saindo de sua conta....");
                    break LOOP;
                default:
                    System.out.println("Opção inválida.");
            }
        }
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
