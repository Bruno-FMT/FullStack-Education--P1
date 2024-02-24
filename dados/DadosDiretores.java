package dados;

import objetos.funcionarios.Diretor;
import objetos.funcionarios.NiveisCargoFuncionario;

import java.util.ArrayList;
import java.util.List;

public class DadosDiretores {
    private static List<Diretor> diretoresCadastrados = new ArrayList<>();

    public static List<Diretor> getDiretoresCadastrados() {
        return diretoresCadastrados;
    }

    public static void adicionarDiretor(Diretor diretor) {
        diretoresCadastrados.add(diretor);
        System.out.println("Aluno adicionado com sucesso.");
    }

    public static void removerDiretorPorId(int id) {
        if (id >= 0 && id < diretoresCadastrados.size()) {
            diretoresCadastrados.remove(id);
            System.out.println("Diretor removido com sucesso.");
        } else {
            System.out.println("Nenhum diretor encontrado com o id informado.");
        }
    }

    public static void removerDiretor(Diretor diretor) {
        if (diretoresCadastrados.contains(diretor)) {
            diretoresCadastrados.remove(diretor);
            System.out.println("Diretor removido com sucesso.");
        } else {
            System.out.println("Nenhum diretor encontrado com o id informado.");
        }
    }

    public static void listarTodosDiretoresComId() {
        System.out.println("Todos os diretores cadastrados");
        for (Diretor diretor : diretoresCadastrados) {
            System.out.println(
                    "Id: " + diretor.getId() +
                    " - Nome: " + diretor.getNome() +
                    ", Idade: " + diretor.getIdade() +
                    ", Salário: " + diretor.getSalario() +
                    ", Status: " + diretor.getNivelCargo()
            );
        }
    }

    public static void listarDiretoresPorNivel(NiveisCargoFuncionario nivel) {
        System.out.println("Diretores com nível " + nivel);
        for (Diretor diretor : diretoresCadastrados) {
            if (diretor.getNivelCargo().equals(nivel)) {
                System.out.println(
                        "Id: " + diretor.getId() +
                        " - Nome: " + diretor.getNome() +
                        ", Idade: " + diretor.getIdade() +
                        ", Salário: " + diretor.getSalario() +
                        ", Status: " + diretor.getNivelCargo()
                );
            }
        }
    }

    public static Diretor getDiretorPorId(int id) {
        if (id >= 0 && id < diretoresCadastrados.size()) {
            return diretoresCadastrados.get(id);
        } else {
            System.out.println("Nenhum Diretor encontrado com o id informado.");
            return null;
        }
    }

    public static ArrayList<Diretor> getDiretorPorNivelCargo(NiveisCargoFuncionario nivel) {
        ArrayList<Diretor> diretores = new ArrayList<>();
        for (Diretor diretor : diretoresCadastrados) {
            if (diretor.getNivelCargo().equals(nivel)) {
                diretores.add(diretor);
            }
        }
        return diretores;
    }
}
