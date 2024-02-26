package dados;

import objetos.funcionarios.Diretor;

import java.util.ArrayList;

public class DadosDiretores {
    private static ArrayList<Diretor> diretoresCadastrados = new ArrayList<>();

    public static ArrayList<Diretor> getDiretoresCadastrados() {
        return diretoresCadastrados;
    }

    public static Diretor getDiretorPorId(int id) {
        try {
            return diretoresCadastrados.get(id);
        } catch (Exception e) {
            throw new IllegalArgumentException("Nenhum diretor encontrado com o id informado.", e);
        }
    }

    public static void adicionarDiretor(Diretor diretor) {
        if (diretorEhCadastrado(diretor)) {
            throw new IllegalArgumentException("Diretor já cadastrado.");
        }
        diretoresCadastrados.add(diretor);
    }

    public static void removerDiretorPorId(int id) {
        if (id < 0 || id > diretoresCadastrados.size()) {
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

    public static Diretor getDiretorPorUsuario(String usuario) {
        for (Diretor diretor : diretoresCadastrados) {
            if (diretor.getUsuario().equals(usuario)) {
                return diretor;
            }
        }
        throw new IllegalArgumentException("Nenhum diretor encontrado com o usuário informado.");
    }

    private static boolean diretorEhCadastrado(Diretor diretor) {
        for (Diretor diretorCadastrado : diretoresCadastrados) {
            if (diretorCadastrado.getUsuario().equals(diretor.getUsuario())) {
                return true;
            }
        }
        return false;
    }

    public static void imprimirListaTodosDiretores() {
        System.out.println("DIRETORES CADASTRADOS");
        for (Diretor diretor : diretoresCadastrados) {
            System.out.println("ID: " + diretor.getId() + ", Diretor:" + diretor.toString());
        }
    }
}