package testes;

import dados.DadosProfessores;
import objetos.funcionarios.Professor;

public class TesteProfessor {
    public static void main(String[] args) {
        System.out.println("TESTES PROFESSOR");
        System.out.println(
                "Professor deve receber: " +
                "nome em String, idade entre 0 e 120, salário em double e anos de cargo em int"
        );
        Professor professor = new Professor("Jane Doe", 40, 3000.50, 3);
        DadosProfessores.adicionarProfessor(professor);
        System.out.println(professor);

        System.out.println("\nNome em branco deve lançar exceção: Nome não pode estar em branco.");
        try {
            Professor professorErroNome = new Professor("", 40, 3000.50, 3);
            System.out.println(professorErroNome);
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("\nIdade maior que 120 deve lançar exceção: Idade deve estar entre 0-120");
        try {
            Professor professorErroIdade = new Professor("Jane Doe", 150, 3000.50, 3);
            System.out.println(professorErroIdade);
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("\ngetNome deve retornar uma String com o nome do professor");
        System.out.println(professor.getNome());

        System.out.println("\nsetNome deve incluir um novo nome ao professor");
        professor.setNome("Jhon Doe");
        System.out.println(professor.getNome());

        System.out.println("\nsetNome em branco deve lançar exceção: Nome não pode estar em branco.");
        try {
            professor.setNome("");
            System.out.println(professor.getNome());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(professor.getNome());
        }

        System.out.println("\ngetIdade deve retornar um int com a idade do professor");
        System.out.println(professor.getIdade());

        System.out.println("\nsetIdade deve incluir uma nova idade ao professor");
        professor.setIdade(41);
        System.out.println(professor.getIdade());

        System.out.println("\nsetIdade maior que 120 deve lançar exceção: Idade deve estar entre 0-120");
        try {
            professor.setIdade(130);
            System.out.println(professor.getIdade());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(professor.getIdade());
        }

        System.out.println("\ngetAnosCargo deve retornar um int com o anos de cargo do professor");
        System.out.println(professor.getAnosCargo());

        System.out.println("\nsetAnosCargo deve incluir um novo ano de cargo ao professor");
        professor.setAnosCargo(13);
        System.out.println(professor.getAnosCargo());

        System.out.println("\nsetAnosCargo negativo deve lançar exceção: Anos de cargo não pode ser negativo");
        try {
            professor.setAnosCargo(-1);
            System.out.println(professor.getAnosCargo());
        } catch (Exception e){
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(professor.getAnosCargo());
        }

        System.out.println("\ngetSalario deve retornar um double com o salário do professor");
        System.out.println(professor.getSalario());

        System.out.println("\nsetSalario deve incluir um novo salário ao professor");
        professor.setSalario(5999.99);
        System.out.println(professor.getSalario());

        System.out.println("\ngetNivelCargo deve retornar o nível do cargo do professor");
        System.out.println(professor.getNivelCargo());

        System.out.println("\nsetNivelCargo deve incluir um novo nível do cargo ao professor passado por String");
        professor.setNivelCargo("EXPERIENTE");
        System.out.println(professor.getNivelCargo());

        System.out.println("\nsetNivelCargo ao receber nível invalido deve lançar exceção: Nível de cargo invalido.");
        try {
            professor.setNivelCargo("AVANÇADO");
            System.out.println(professor.getNivelCargo());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(professor.getNivelCargo());
        }

        System.out.println("\ngetId deve retornar um int com o id de professor (que será a posição dele em dadosProfessores)");
        System.out.println(professor.getId());

        System.out.println("\ngetId deve retornar -1 caso o professor em esteja em dadosProfessores");
        DadosProfessores.removerProfessorPorId(0);
        System.out.println(professor.getId());

        System.out.println("\nimprimirNiveisCargo deve mostrar no console todas as opções de níveis de cargo");
        professor.imprimirNiveisCargo();
    }
}
