package dados;

import objetos.funcionarios.Diretor;

import java.util.ArrayList;
import java.util.List;

public class DadosDiretores {
    public static List<Diretor> diretoresCadastrados = new ArrayList<>();

    public void adicionarDiretor(Diretor diretor) {
        diretoresCadastrados.add(diretor);
        System.out.println("Aluno adicionado com sucesso.");
    }

    public void removerDiretorPorId(int id) {
        for (Diretor diretor : diretoresCadastrados) {
            if (diretor.getId() == id) {
                diretoresCadastrados.remove(diretor);
                System.out.println("Diretor removido com sucesso.");
            }
        }
    }

    public Diretor getDiretorPorId(int id) {
        for (Diretor diretor : diretoresCadastrados) {
            if (diretor.getId() == id) {
                return diretor;
            }
        }
        System.out.println("Nenhum Diretor encontrado com o ID informado.");
        return null;
    }
}
