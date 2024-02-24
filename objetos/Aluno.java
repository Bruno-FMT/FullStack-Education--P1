package objetos;

import dados.DadosAlunos;
import enums.StatusMatricula;
import dados.DadosTurmas;

import java.util.ArrayList;
import java.util.List;

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

    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isBlank() || nome.length() < 5) {
            throw new IllegalArgumentException("Nome deve ter conteúdo e pelo menos 5 caracteres");
        }
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0 || idade > 120) {
            throw new IllegalArgumentException("Idade deve estar entre 0-120");
        }
        this.idade = idade;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        boolean jaExiste = false;
        for (Aluno aluno : DadosAlunos.getAlunosCadastrados()) {
            if (aluno.getUsuario().equals(usuario)) {
                jaExiste = true;
                break;
            }
        }
        if (jaExiste) {
            throw new IllegalArgumentException("Usuário já existente!");
        }
        if (usuario.length() > 20) {
            throw new IllegalArgumentException("Usuário muito longo! (Máximo: 20)");
        }
        if (usuario.length() < 4) {
            throw new IllegalArgumentException("Usuário muito curto! (Mínimo: 4)");
        }
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha.length() < 8) {
            throw new IllegalArgumentException("Senha muito curta! (Mínimo: 8)");
        }
        this.senha = senha;
    }

    public StatusMatricula getStatusMatricula() {
        return statusMatricula;
    }

    public void setStatusMatricula(String statusMatricula) {
        try {
            this.statusMatricula = StatusMatricula.valueOf(statusMatricula);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Status de matrícula inválido", e);
        }
    }

    public int getId() {
        List<Aluno> alunos = DadosAlunos.getAlunosCadastrados();
        if (alunos.contains(this)) {
            return alunos.indexOf(this);
        }
        throw new IllegalArgumentException("Aluno não encontrado.");
    }

    public static int getId(String usuario) {
        List<Aluno> alunos = DadosAlunos.getAlunosCadastrados();
        for (Aluno aluno : alunos) {
            if (aluno.getUsuario().equals(usuario)) {
                return alunos.indexOf(aluno);
            }
        }
        throw new IllegalArgumentException("Aluno não encontrado.");
    }

    public ArrayList<Curso> getCursosCadastrados() {
        List<Turma> turmas = DadosTurmas.getTurmasCadastradas();
        ArrayList<Curso> cursos = new ArrayList<>();
        for (Turma turma : turmas) {
            if (turma.getAlunos().contains(this)) {
                cursos.add(turma.getCurso());
            }
        }
        return cursos;
    }

    public static void imprimirOpcoesStatusMatricula() {
        StatusMatricula[] opcoesStatus = StatusMatricula.values();
        for (int i = 0; i < opcoesStatus.length; i++) {
            System.out.println((i + 1) + "- " + opcoesStatus[i]);
        }
    }

    @Override
    public String toString() {
        return "{nome: " + nome + ", idade: " + idade + ", status: " + statusMatricula + "}";
    }

    public void trancarAtivarCadastro () {
        if (this.statusMatricula.equals(StatusMatricula.ATIVO)) {
            setStatusMatricula("TRANCADO");
            return;
        }
        if (this.statusMatricula.equals(StatusMatricula.TRANCADO)) {
            setStatusMatricula("ATIVO");
            return;
        }
        if (this.statusMatricula.equals(StatusMatricula.FORMADO)){
            throw new IllegalArgumentException("Aluno formado não pode alterar seu status de matrícula.");
        }
    }

    public void formar() {
        if (this.statusMatricula.equals(StatusMatricula.ATIVO)) {
            setStatusMatricula("FORMADO");
            return;
        }
        if (this.statusMatricula.equals(StatusMatricula.TRANCADO)) {
            throw new IllegalArgumentException("Aluno com a matrícula trancada não pode se formar.");
        }
        if (this.statusMatricula.equals(StatusMatricula.FORMADO)){
            throw new IllegalArgumentException("Aluno já está formado.");
        }
    }

    public void listarCursosCadastrados() {
        ArrayList<Curso> cursos = getCursosCadastrados();
        System.out.println("Aluno(a) " + this.getNome() + " está cadastrado(a) no(s) curso(s): ");
        for (Curso curso : cursos) {
            System.out.println(curso.getNome());
        }
    }
}
