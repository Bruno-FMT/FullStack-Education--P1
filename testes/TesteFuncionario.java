package testes;

import objetos.funcionarios.Funcionario;

public class TesteFuncionario {
    public static void main(String[] args) {
        System.out.println("TESTES FUNCIONÁRIO");
        System.out.println(
            "Funcionário deve receber: " +
            "nome em String, idade entre 0 e 120, salário em double e anos de cargo em int"
        );
        Funcionario funcionario = new Funcionario("Jane Doe", 40, 3000.50, 3);
        System.out.println(funcionario);

        System.out.println("\nNome em branco deve lançar exceção: Nome não pode estar em branco.");
        try {
            Funcionario funcionarioErroNome = new Funcionario("", 40, 3000.50, 3);
            System.out.println(funcionarioErroNome);
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("\nIdade maior que 120 deve lançar exceção: Idade deve estar entre 0-120");
        try {
            Funcionario funcionarioErroIdade = new Funcionario("Jane Doe", 150, 3000.50, 3);
            System.out.println(funcionarioErroIdade);
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("\ngetNome deve retornar uma String com o nome do funcionário");
        System.out.println(funcionario.getNome());

        System.out.println("\nsetNome deve incluir um novo nome ao funcionário");
        funcionario.setNome("Jhon Doe");
        System.out.println(funcionario.getNome());

        System.out.println("\nsetNome em branco deve lançar exceção: Nome não pode estar em branco.");
        try {
            funcionario.setNome("");
            System.out.println(funcionario.getNome());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(funcionario.getNome());
        }

        System.out.println("\ngetIdade deve retornar um int com a idade do funcionário");
        System.out.println(funcionario.getIdade());

        System.out.println("\nsetIdade deve incluir uma nova idade ao funcionário");
        funcionario.setIdade(41);
        System.out.println(funcionario.getIdade());

        System.out.println("\nsetIdade maior que 120 deve lançar exceção: Idade deve estar entre 0-120");
        try {
            funcionario.setIdade(130);
            System.out.println(funcionario.getIdade());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(funcionario.getIdade());
        }

        System.out.println("\ngetAnosCargo deve retornar um int com o anos de cargo do funcionário");
        System.out.println(funcionario.getAnosCargo());

        System.out.println("\nsetAnosCargo deve incluir um novo ano de cargo ao funcionário");
        funcionario.setAnosCargo(13);
        System.out.println(funcionario.getAnosCargo());

        System.out.println("\nsetAnosCargo negativo deve lançar exceção: Anos de cargo não pode ser negativo");
        try {
            funcionario.setAnosCargo(-1);
            System.out.println(funcionario.getAnosCargo());
        } catch (Exception e){
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(funcionario.getAnosCargo());
        }

        System.out.println("\ngetSalario deve retornar um double com o salário do funcionário");
        System.out.println(funcionario.getSalario());

        System.out.println("\nsetSalario deve incluir um novo salário ao funcionário");
        funcionario.setSalario(5999.99);
        System.out.println(funcionario.getSalario());

        System.out.println("\ngetNivelCargo deve retornar o nível do cargo do funcionário");
        System.out.println(funcionario.getNivelCargo());

        System.out.println("\nsetNivelCargo deve incluir um novo nível do cargo ao funcionário passado por String");
        funcionario.setNivelCargo("EXPERIENTE");
        System.out.println(funcionario.getNivelCargo());

        System.out.println("\nsetNivelCargo ao receber nível invalido deve lançar exceção: Nível de cargo invalido.");
        try {
            funcionario.setNivelCargo("AVANÇADO");
            System.out.println(funcionario.getNivelCargo());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(funcionario.getNivelCargo());
        }

        System.out.println("\nimprimirNiveisCargo deve mostrar no console todas as opções de níveis de cargo");
        Funcionario.imprimirNiveisCargo();

        System.out.println("**** TESTE FUNCIONÁRIO CONCLUÍDO COM SUCESSO! ****");
    }
}
