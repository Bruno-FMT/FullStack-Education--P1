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

    public Aluno() {}

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
        if (nome.isBlank() || nome.length() < 5) {
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
        if (usuario.length() >= 4 && usuario.length() <= 20 && !jaExiste) {
            this.usuario = usuario;
            return true;
        }
        if (jaExiste) {
            System.out.println("Usuário já existente!");
        }
        if (usuario.length() > 20) {
            System.out.println("Usuário muito longo! (Máximo: 20)");
        }
        System.out.println("Usuário muito curto! (Mínimo: 4)");
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
