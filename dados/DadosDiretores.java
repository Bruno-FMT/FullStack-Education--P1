package dados;

import objetos.funcionarios.Diretor;

import java.util.ArrayList;
import java.util.List;

public class DadosDiretores {
    private static List<Diretor> diretoresCadastrados = new ArrayList<>();

    public static List<Diretor> getDiretoresCadastrados() {
        return diretoresCadastrados;
    }

    public static void adicionarDiretor(Diretor diretor) {
        if (diretorEhCadastrado(diretor)) {
            throw new IllegalArgumentException("Diretor já cadastrado.");
        }
        diretoresCadastrados.add(diretor);
    }

    public static void removerDiretorPorId(int id) {
        if(id < 0 || id > diretoresCadastrados.size()) {
            throw new IllegalArgumentException("Nenhum diretor encontrado com o id informado.");
        }
        diretoresCadastrados.remove(id);
    }

    public static void removerDiretor(Diretor diretor) {
        if(!diretoresCadastrados.contains(diretor)) {
            throw new IllegalArgumentException("Diretor não encontrado");
        }
        diretoresCadastrados.remove(diretor);
    }

    public static Diretor getDiretorPorId(int id) {
        if(id < 0 || id > diretoresCadastrados.size()) {
            throw new IllegalArgumentException("Nenhum diretor encontrado com o id informado.");
        }
        return diretoresCadastrados.get(id);
    }

    private static boolean diretorEhCadastrado(Diretor diretor){
        for (Diretor diretorCadastrado : diretoresCadastrados) {
            if (diretorCadastrado.getUsuario().equals(diretor.getUsuario())) {
                return true;
            }
        }
        return false;
    }
}
