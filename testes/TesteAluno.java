package testes;

import dados.DadosAlunos;
import objetos.Aluno;

public class TesteAluno {
    public static void main(String[] args) {
        System.out.println("TESTES ALUNO");
        System.out.println("Aluno deve receber um nome em String e uma idade entre 0 e 120");
        Aluno aluno = new Aluno("Jane Doe", 40, "janedoe", "senha1234");
        Aluno aluno2 = new Aluno("Jhon Doe", 40, "jhondoe", "senha1234");
        System.out.println(aluno);

        System.out.println("\nIdade maior que 120 deve lançar exceção: Idade deve estar entre 0-120");
        try {
            Aluno alunoErroIdade = new Aluno("João Silva", 150, "novaJaneDoe", "senha1234");
            System.out.println(alunoErroIdade);
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("\ngetNome deve retornar uma String com o nome do aluno");
        System.out.println(aluno.getNome());

        System.out.println("\nsetNome deve incluir um novo nome ao aluno");
        aluno.setNome("Jhon Doe");
        System.out.println(aluno.getNome());

        System.out.println("\nsetNome em branco deve lançar exceção: Nome não pode estar em branco.");
        try {
            aluno.setNome("");
            System.out.println(aluno.getNome());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(aluno.getNome());
        }

        System.out.println("\nsetNome menor que 5 deve lançar exceção: Nome deve ter conteúdo e pelo menos 5 caracteres");
        try {
            aluno.setNome("ana");
            System.out.println(aluno.getNome());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(aluno.getNome());
        }

        System.out.println("\ngetIdade deve retornar um int com a idade do aluno");
        System.out.println(aluno.getIdade());

        System.out.println("\nsetIdade deve incluir uma nova idade ao aluno");
        aluno.setIdade(41);
        System.out.println(aluno.getIdade());

        System.out.println("\nsetIdade maior que 120 deve lançar exceção: Idade deve estar entre 0-120");
        try {
            aluno.setIdade(130);
            System.out.println(aluno.getIdade());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(aluno.getIdade());
        }

        System.out.println("\ngetUsuario deve retornar uma String com o usuário do aluno");
        System.out.println(aluno.getUsuario());

        System.out.println("\nsetUsuario deve incluir um novo nome de usuário ao aluno");
        aluno.setUsuario("novoUsuario");
        System.out.println(aluno.getUsuario());

        System.out.println("\nsetUsuario menor que 4 deve lançar exceção: Usuário muito curto! (Mínimo: 4)");
        try {
            aluno.setUsuario("use");
            System.out.println(aluno.getUsuario());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(aluno.getUsuario());
        }

        System.out.println("\nsetUsuario maior que 20 deve lançar exceção: Usuário muito longo! (Máximo: 20)");
        try {
            aluno.setUsuario("usuario-muito-longo-maior-que-20");
            System.out.println(aluno.getUsuario());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(aluno.getUsuario());
        }

        System.out.println("\nsetUsuario já existente deve lançar exceção: Usuário já existente");
        try {
            aluno.setUsuario("jhondoe");
            System.out.println(aluno.getUsuario());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(aluno.getUsuario());
        }

        System.out.println("\ngetSenha deve retornar uma String com a senha do aluno");
        System.out.println(aluno.getSenha());

        System.out.println("\nsetSenha deve incluir uma nova senha ao aluno");
        aluno.setSenha("novaSenha");
        System.out.println(aluno.getSenha());

        System.out.println("\nsetSenha menor que 8 deve lançar exceção: Senha muito curta! (Mínimo: 8)");
        try {
            aluno.setSenha("senha");
            System.out.println(aluno.getSenha());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(aluno.getSenha());
        }

        System.out.println("\ngetId deve retornar um int com o id de Aluno (que será a posição dele em dadosAlunos)");
        System.out.println(aluno.getId());

        System.out.println("\ngetId deve retornar -1 caso o aluno em esteja em dadosAlunos");
        DadosAlunos.removerAlunoPorId(0);
        System.out.println(aluno.getId());

        System.out.println("\ngetStatusMatricula deve retornar o status da matrícula do aluno");
        System.out.println(aluno.getStatusMatricula());

        System.out.println("\nsetStatusMatricula incluir novo o status da matrícula do aluno passado por String");
        aluno.setStatusMatricula("TRANCADO");
        System.out.println(aluno.getStatusMatricula());

        System.out.println("\nsetStatusMatricula ao receber status invalido deve lançar exceção: Status de matrícula invalido.");
        try {
            aluno.setStatusMatricula("TRANCADA");
            System.out.println(aluno.getStatusMatricula());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(aluno.getStatusMatricula());
        }

        System.out.println("\ntoString deve trazer nome e idade do aluno");
        System.out.println(aluno.toString());

        System.out.println("\nimprimirOpcoesStatusMatricula deve mostrar no console todas as opções de status de matrícula");
        Aluno.imprimirOpcoesStatusMatricula();

        System.out.println("**** TESTE ALUNO CONCLUÍDO COM SUCESSO! ****");
    }
}
