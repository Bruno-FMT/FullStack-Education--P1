package testes;

import dados.DadosDiretores;
import objetos.funcionarios.Diretor;

public class TesteDadosDiretores {
    public static void main(String[] args) {
        System.out.println("TESTE DADOS DIRETORES");
        Diretor diretor = new Diretor("Jane Doe", 40, 10000.00, 10, "janedoe", "senha1234");

        System.out.println("getDiretoresCadastrados deve retornar a lista de todos os diretores cadastrados");
        System.out.println(DadosDiretores.getDiretoresCadastrados());

        System.out.println("\nadicionarDiretor deve adicionar um novo diretor a lista de diretores cadastrados, isso ocorre quando o diretor é cadastrado");
        Diretor diretor2 = new Diretor("Jhon Doe", 50, 5000.00, 5, "jhondoe", "senha1234");
        System.out.println(DadosDiretores.getDiretoresCadastrados());

        System.out.println("\nadicionarDiretor já cadastrado deve lançar exceção: Diretor já cadastrado");
        try {
            DadosDiretores.adicionarDiretor(diretor2);
            System.out.println(DadosDiretores.getDiretoresCadastrados());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosDiretores.getDiretoresCadastrados());
        }

        System.out.println("\nremoverDiretorPorId deve remover da lista de diretores cadastrados o diretor na posição informada");
        DadosDiretores.removerDiretorPorId(1);
        System.out.println(DadosDiretores.getDiretoresCadastrados());

        System.out.println("\nremoverDiretorPorId posição inexistente deve lançar exceção: Nenhum diretor encontrado com o id informado");
        try {
            DadosDiretores.removerDiretorPorId(30);
            System.out.println(DadosDiretores.getDiretoresCadastrados());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosDiretores.getDiretoresCadastrados());
        }

        System.out.println("\ngetDiretorPorId trará as informações do diretor na posição informada");
        System.out.println(DadosDiretores.getDiretorPorId(0));

        System.out.println("\ngetDiretorPorId posição inexistente deve lançar exceção: Nenhum diretor encontrado com o id informado");
        try {
            DadosDiretores.getDiretorPorId(30);
            System.out.println(DadosDiretores.getDiretoresCadastrados());
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println(DadosDiretores.getDiretoresCadastrados());
        }

        System.out.println("**** TESTE DADOS DIRETORES CONCLUÍDO COM SUCESSO! ****");
    }
}
