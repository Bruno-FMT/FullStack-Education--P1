package objetos.funcionarios;

public class Funcionario implements IFuncionario {
    private String nome;
    private int idade;
    private double salario;
    private NiveisCargoFuncionario nivelCargo;
    private int anosCargo; //Tempo de trabalho na empresa
    private double valorAdicionalSalario; //Valor adicional pela promoção de cargo - nivel ou diretor

    public Funcionario(){
        this.nivelCargo = NiveisCargoFuncionario.INICIANTE;
    }

    public Funcionario(String nome, int idade, double salario, int anosCargo) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.anosCargo = anosCargo;
        this.nivelCargo = NiveisCargoFuncionario.INICIANTE;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getAnosCargo() {
        return anosCargo;
    }

    public void setAnosCargo(int anosCargo) {
        this.anosCargo = anosCargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getValorAdicionalSalario() {
        return valorAdicionalSalario;
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

    //Promover - apenas salário
    public void promover(double valorAdicionalSalario) {
        this.valorAdicionalSalario = valorAdicionalSalario;
        this.setSalario(this.salario + valorAdicionalSalario);
    }

    //Promover - Cargo com aumento salarial
    public void promover(String nivelCargo, double valorAdicionalSalario) {
        this.setNivelCargo(nivelCargo);
        this.valorAdicionalSalario = valorAdicionalSalario;

        if (nivelCargo.equals("AVANCADO") || nivelCargo.equals("EXPERIENTE")) {
            this.salario += valorAdicionalSalario;
        } else {
            System.out.println("Não há promoção para o cargo de nível INICIANTE.");
        }
    }

    public void promover(Funcionario funcionario,String nivelCargo) {
        funcionario.setNivelCargo(nivelCargo);
    }

    public static void imprimirNiveisCargo() {
        NiveisCargoFuncionario[] niveisCargo = NiveisCargoFuncionario.values();
        for (int i = 0; i < niveisCargo.length; i++) {
            System.out.println((i + 1) + "- " + niveisCargo[i]);
        }
    }
}
