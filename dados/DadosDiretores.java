package dados;

import objetos.funcionarios.Diretor;

import java.util.ArrayList;
import java.util.List;

public class DadosDiretores {
    private static List<Diretor> diretoresCadastrados = new ArrayList<>();

    public static List<Diretor> getDiretoresCadastrados() {
        return diretoresCadastrados;
    }

    public void adicionarDiretor(Diretor diretor) {
        diretoresCadastrados.add(diretor);
        System.out.println("Aluno adicionado com sucesso.");
    }

    public void removerDiretorPorId(int id) {
        if (id >= 0 && id < diretoresCadastrados.size()) {
            diretoresCadastrados.remove(id);
            System.out.println("Diretor removido com sucesso.");
        } else {
            System.out.println("Nenhum diretor encontrado com o id informado.");
        }
    }

    public Diretor getDiretorPorId(int id) {
        if (id >= 0 && id < diretoresCadastrados.size()) {
            return diretoresCadastrados.get(id);
        } else {
            System.out.println("Nenhum Diretor encontrado com o id informado.");
            return null;
        }
    }
}
