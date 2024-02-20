package testes;

import dados.DadosDiretores;
import objetos.funcionarios.Diretor;
import objetos.funcionarios.Funcionario;

public class TesteDiretor {
    public static void main(String[] args) {
        System.out.println("TESTES DIRETOR");
        System.out.println(
                "Diretor deve receber: " +
                "nome em String, idade entre 0 e 120, salário em double e anos de cargo em int"
        );
        Diretor diretor = new Diretor("Jane Doe", 40, 3000.50, 3, "janedoe", "senha1234");
        System.out.println(diretor);

        System.out.println("\nNome em branco deve lançar exceção: Nome não pode estar em branco.");
        try {
            Diretor professorErroNome = new Diretor("", 40, 3000.50, 3, "professor", "senha1234");
            System.out.println(professorErroNome);
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("\nIdade maior que 120 deve lançar exceção: Idade deve estar entre 0-120");
        try {
            Diretor professorErroIdade = new Diretor("Jane Doe", 150, 3000.50, 3, "janedoe", "senha1234");
            System.out.println(professorErroIdade);
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("\ngetNome deve retornar uma String com o nome do professor");
        System.out.println(diretor.getNome());

        System.out.println("\nsetNome deve incluir um novo nome ao diretor");
        diretor.setNome("Jhon Doe");
        System.out.println(diretor.getNome());

        System.out.println("\nsetNome em branco deve lançar exceção: Nome não pode estar em branco.");
        try {
            diretor.setNome("");
            System.out.println(diretor.getNome());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(diretor.getNome());
        }

        System.out.println("\ngetIdade deve retornar um int com a idade do diretor");
        System.out.println(diretor.getIdade());

        System.out.println("\nsetIdade deve incluir uma nova idade ao diretor");
        diretor.setIdade(41);
        System.out.println(diretor.getIdade());

        System.out.println("\nsetIdade maior que 120 deve lançar exceção: Idade deve estar entre 0-120");
        try {
            diretor.setIdade(130);
            System.out.println(diretor.getIdade());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(diretor.getIdade());
        }

        System.out.println("\ngetAnosCargo deve retornar um int com o anos de cargo do diretor");
        System.out.println(diretor.getAnosCargo());

        System.out.println("\nsetAnosCargo deve incluir um novo ano de cargo ao diretor");
        diretor.setAnosCargo(13);
        System.out.println(diretor.getAnosCargo());

        System.out.println("\nsetAnosCargo negativo deve lançar exceção: Anos de cargo não pode ser negativo");
        try {
            diretor.setAnosCargo(-1);
            System.out.println(diretor.getAnosCargo());
        } catch (Exception e){
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(diretor.getAnosCargo());
        }

        System.out.println("\ngetSalario deve retornar um double com o salário do diretor");
        System.out.println(diretor.getSalario());

        System.out.println("\nsetSalario deve incluir um novo salário ao diretor");
        diretor.setSalario(5999.99);
        System.out.println(diretor.getSalario());

        System.out.println("\ngetNivelCargo deve retornar o nível do cargo do diretor");
        System.out.println(diretor.getNivelCargo());

        System.out.println("\nsetNivelCargo deve incluir um novo nível do cargo ao diretor passado por String");
        diretor.setNivelCargo("EXPERIENTE");
        System.out.println(diretor.getNivelCargo());

        System.out.println("\nsetNivelCargo ao receber nível invalido deve lançar exceção: Nível de cargo invalido.");
        try {
            diretor.setNivelCargo("AVANÇADO");
            System.out.println(diretor.getNivelCargo());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(diretor.getNivelCargo());
        }

        System.out.println("\ngetId deve retornar um int com o id de diretor (que será a posição dele em dadosProfessores)");
        System.out.println(diretor.getId());

        System.out.println("\ngetId deve retornar -1 caso o diretor em esteja em dadosProfessores");
        DadosDiretores.getDiretorPorId(0);
        System.out.println(diretor.getId());

        System.out.println("\ngetUsuario deve retornar uma String com os dados do diretor\"");
        System.out.println(diretor.getUsuario());

        System.out.println("\nsetUsuario deve incluir um novo nome de usuário ao diretor");
        diretor.setUsuario("novoUsuario");
        System.out.println(diretor.getUsuario());

        System.out.println("\ngetSenha deve retornar uma String com a senha do diretor");
        System.out.println(diretor.getSenha());

        System.out.println("\nsetSenha deve incluir uma nova senha ao diretor");
        diretor.setSenha("nova-senha-1234");
        System.out.println(diretor.getSenha());

        System.out.println("\npromover deve incluir um novo nível de cargo ao diretor");
        diretor.promover(diretor, "AVANCADO");

        System.out.println("\ntoString deve trazer nome e nível do diretor");
        System.out.println(diretor.toString());

        System.out.println("**** TESTE DIRETOR CONCLUÍDO COM SUCESSO! ****");
    }
}
