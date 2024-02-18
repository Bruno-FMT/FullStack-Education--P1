package objetos;

import dados.DadosAlunos;
import util.PedirEntrada;

import java.util.List;
import java.util.Scanner;

public class Aluno {
    private String nome;
    private int idade;
    private String usuario;
    private String senha;

    private StatusMatricula statusMatricula;

    public Aluno(String nome, int idade, String usuario, String senha) {
        setNome(nome);
        setIdade(idade);
        setUsuario(usuario);
        setSenha(senha);
        setStatusMatricula("ATIVO");
        DadosAlunos.adicionarAluno(this);
    }
    public Aluno(String nome, int idade) {
        setNome(nome);
        setIdade(idade);
        setStatusMatricula("ATIVO");
    }

    public Aluno() {
//        criarAluno();
//        setStatusMatricula("ATIVO");
    }

    public void criarAluno() {
        definirNome();
        if (!continuar) {return;}

        definirIdade();
        if (!continuar) {return;}

        definirUsuario();
        if (!continuar) {return;}

        definirSenha();
        if (!continuar) {return;}
        DadosAlunos.adicionarAluno(this);
    }
private boolean continuar = true;
    public void definirNome() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite seu nome: ");
        while (true) {
            String nome = PedirEntrada.pedirString(scan);

            if (setNome(nome)) {
                System.out.println("Quer continuar? [s/n]");
                if (!PedirEntrada.pedirBoolean(scan)) { continuar = false; }
                return;
            }
            System.out.println("Nome inválido.");

            System.out.println("Quer continuar? [s/n]"); //TODO: Refatorar e perguntar quando der erro ou depois de pedir o dado (para todos os métodos parecidos)
            if (!PedirEntrada.pedirBoolean(scan)) {
                continuar = false;
                return;
            }

            System.out.print("Digite um nome válido: ");
        }
    }
    public void definirIdade() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite sua idade: ");
        while (true) {
            int idade = PedirEntrada.pedirInt(scan);

            if (setIdade(idade)) {
                System.out.println("Quer continuar? [s/n]");
                if (!PedirEntrada.pedirBoolean(scan)) { continuar = false; }
                return;
            }
            System.out.println("Idade inválida.");

            System.out.println("Quer continuar? [s/n]");
            if (!PedirEntrada.pedirBoolean(scan)) {
                continuar = false;
                return;
            }
            System.out.print("Digite uma idade entre 0 e 120: ");
        }
    }
    public void definirUsuario() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite seu usuário: ");
        while (true) {
            String usuario = PedirEntrada.pedirString(scan);

            if (setUsuario(usuario)) {
                System.out.println("Quer continuar? [s/n]");
                if (!PedirEntrada.pedirBoolean(scan)) { continuar = false; }
                return;
            }
            System.out.println("Usuário inválido.");

            System.out.println("Quer continuar? [s/n]");
            if (!PedirEntrada.pedirBoolean(scan)) {
                continuar = false;
                return;
            }
            System.out.print("Digite um usuário válido: ");
        }
    }
    public void definirSenha() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite sua senha: ");
        while (true) {
            String senha = PedirEntrada.pedirString(scan);

            if (setSenha(senha)) {
                System.out.println("Quer continuar? [s/n]");
                if (!PedirEntrada.pedirBoolean(scan)) { continuar = false; }
                return;
            }
            System.out.println("Senha inválida.");

            System.out.println("Quer continuar? [s/n]");
            if (!PedirEntrada.pedirBoolean(scan)) {
                continuar = false;
                return;
            }
            System.out.print("Digite uma senha válida: ");
        }
    }


    public void listarCurso() {

    }

    public void adicionarCurso() {

    }

    public void removerCurso() {

    }

    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        if (nome.isBlank()) {
            return false;
        }
        this.nome = nome;
        return true;
    }

    public int getIdade() {
        return idade;
    }

    public boolean setIdade(int idade) {
        if (idade >= 0 && idade <= 120) {
            this.idade = idade;
            return true;
        }
        return false;
    }

    public String getUsuario() {
        return usuario;
    }

    public boolean setUsuario(String usuario) {
        boolean jaExiste = false;
        for (Aluno aluno : DadosAlunos.getAlunosCadastrados()) {
            if (aluno.getUsuario().equals(usuario)) {
                jaExiste = true;
                break;
            }
        }
        if (usuario.length() < 20 && !jaExiste) {
            this.usuario = usuario;
            return true;
        }
        if (jaExiste) {
            System.out.println("Usuário já existente!");
        }
        System.out.println("Usuário muito longo!");
        return false;
    }

    public String getSenha() {
        return senha;
    }

    public boolean setSenha(String senha) {
        if (senha.length() >= 8) {
            this.senha = senha;
            return true;
        } else {
            System.out.println("Senha muito curta!");
            return false;
        }
    }

    public StatusMatricula getStatusMatricula() {
        return statusMatricula;
    }

    public boolean setStatusMatricula(String statusMatricula) {
        try {
            this.statusMatricula = StatusMatricula.valueOf(statusMatricula);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Status de matrícula invalido.");
            return false;
        }
    }

    public static int getId(String usuario) {
        List<Aluno> alunos = DadosAlunos.getAlunosCadastrados();
        for (Aluno aluno : alunos) {
            if (aluno.getUsuario().equals(usuario)) {
                return alunos.indexOf(aluno);
            }
        }
        System.out.println("Aluno não encontrado.");
        return -1;
    }

    public int getId() {
        List<Aluno> alunos = DadosAlunos.getAlunosCadastrados();
        if (alunos.contains(this)) {
            return alunos.indexOf(this);
        }
        System.out.println("Aluno não encontrado.");
        return -1;
    }

    public static void imprimirOpcoesStatusMatricula() {
        StatusMatricula[] opcoesStatus = StatusMatricula.values();
        for (int i = 0; i < opcoesStatus.length; i++) {
            System.out.println((i + 1) + "- " + opcoesStatus[i]);
        }
    }
}
