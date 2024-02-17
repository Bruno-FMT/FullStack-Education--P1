package dados;

import objetos.funcionarios.Professor;

import java.util.ArrayList;
import java.util.List;

public class DadosProfessores {
    private static List<Professor> professoresCadastrados = new ArrayList<>();

    public static List<Professor> getProfessoresCadastrados() {
        return professoresCadastrados;
    }

    public void adicionarProfessor(Professor professor) {
        professoresCadastrados.add(professor);
        System.out.println("Professor adicionado com sucesso.");
    }

    public void adicionarProfessores(List<Professor> professores){
        professoresCadastrados.addAll(professores);
    }

    public void removerProfessorPorId(int id) {
        if (id >= 0 && id < professoresCadastrados.size()) {
            professoresCadastrados.remove(id);
            System.out.println("Professor removido com sucesso.");
        } else {
            System.out.println("Nenhum Professor encontrado com o id informado.");
        }
    }

    public Professor getProfessorPorId(int id) {
        if (id >= 0 && id < professoresCadastrados.size()) {
            return professoresCadastrados.get(id);
        } else {
            System.out.println("Nenhum Professor encontrado com o id informado.");
            return null;
        }
    }
}
