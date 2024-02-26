package objetos.funcionarios;

import enums.NiveisCargoFuncionario;
import interfaces.IFuncionario;

import dados.DadosDiretores;
import dados.DadosProfessores;

public class Funcionario implements IFuncionario {
    private String nome;
    private int idade;
    private String usuario;
    private String senha;
    private double salario;
    private NiveisCargoFuncionario nivelCargo;
    private int anosCargo;

    public Funcionario(String nome, int idade, double salario, int anosCargo, String usuario, String senha) {
        setNome(nome);
        setIdade(idade);
        setUsuario(usuario);
        setSenha(senha);
        setSalario(salario);
        setAnosCargo(anosCargo);
        this.nivelCargo = NiveisCargoFuncionario.INICIANTE;
    }
    public Funcionario() {
        this.nivelCargo = NiveisCargoFuncionario.INICIANTE;
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
        for (Funcionario funcionario : DadosProfessores.getProfessoresCadastrados()) {
            if (funcionario.getUsuario().equals(usuario)) {
                jaExiste = true;
                break;
            }
        }
        for (Funcionario funcionario : DadosDiretores.getDiretoresCadastrados()) {
            if (funcionario.getUsuario().equals(usuario)) {
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

    public int getAnosCargo() {
        return anosCargo;
    }

    public void setAnosCargo(int anosCargo) {
        if (anosCargo < 0) {
            throw new IllegalArgumentException("Anos de cargo não pode ser negativo.");
        }
        this.anosCargo = anosCargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode estar em branco.");
        }
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("Salário deve ser maior que zero.");
        }
        this.salario = salario;
    }

    public NiveisCargoFuncionario getNivelCargo() {
        return nivelCargo;
    }

    public void setNivelCargo(String nivelCargo) {
        try {
            this.nivelCargo = NiveisCargoFuncionario.valueOf(nivelCargo);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Nível de cargo invalido.", e);
        }
    }

    public void promover() {
        if (this.nivelCargo.name().equals("INICIANTE")) {
            setNivelCargo("EXPERIENTE");
        } else if (this.nivelCargo.name().equals("EXPERIENTE")) {
            setNivelCargo("AVANCADO");
        } else {
            throw new IllegalArgumentException("Funcionário já está no último nível de promoção: " + this.nivelCargo);
        }
    }

    public void promover(double valorAdicionalSalario) {
        if (this.nivelCargo.name().equals("INICIANTE")) {
            setNivelCargo("EXPERIENTE");
            this.setSalario(this.salario + valorAdicionalSalario);
        } else if (this.nivelCargo.name().equals("EXPERIENTE")) {
            setNivelCargo("AVANCADO");
            this.setSalario(this.salario + valorAdicionalSalario);
        } else {
            throw new IllegalArgumentException("Funcionário já está no último nível de promoção: " + this.nivelCargo);
        }
    }

    public static void imprimirNiveisCargo() {
        NiveisCargoFuncionario[] niveisCargo = NiveisCargoFuncionario.values();
        for (int i = 0; i < niveisCargo.length; i++) {
            System.out.println((i + 1) + "- " + niveisCargo[i]);
        }
    }

    @Override
    public String toString() {
        return "Funcionário{" +
                "nome: " + nome +
                ", idade: " + idade +
                ", nível: " + nivelCargo +
                ", anos no cargo: " + anosCargo +
                '}';
    }
}