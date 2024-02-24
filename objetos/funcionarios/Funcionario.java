package objetos.funcionarios;

import dados.DadosDiretores;
import dados.DadosProfessores;

public class Funcionario implements IFuncionario {
    private String nome;
    private int idade;
    private String usuario;
    private String senha;
    private double salario;
    private NiveisCargoFuncionario nivelCargo;
    private int anosCargo; //Tempo de trabalho na empresa

    public Funcionario(String nome, int idade, double salario, int anosCargo) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.anosCargo = anosCargo;
        this.nivelCargo = NiveisCargoFuncionario.INICIANTE;
    }
    public Funcionario() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
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
        this.anosCargo = anosCargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void promover(Funcionario funcionario,String nivelCargo) {
        funcionario.setNivelCargo(nivelCargo);
    }

    public NiveisCargoFuncionario getNivelCargo() {
        return nivelCargo;
    }

    public boolean setNivelCargo(String nivelCargo) {
        try {
            this.nivelCargo = NiveisCargoFuncionario.valueOf(nivelCargo);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Nível de cargo invalido.");
            return false;
        }
    }

    public static void imprimirNiveisCargo() {
        NiveisCargoFuncionario[] niveisCargo = NiveisCargoFuncionario.values();
        for (int i = 0; i < niveisCargo.length; i++) {
            System.out.println((i + 1) + "- " + niveisCargo[i]);
        }
    }
}
