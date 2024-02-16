package dados;

import objetos.funcionarios.Professor;

import java.util.ArrayList;
import java.util.List;

public class DadosProfessores {
    public static List<Professor> professoresCadastrados = new ArrayList<>();

    public void adicionarProfessor(Professor professor) {
        professoresCadastrados.add(professor);
        System.out.println("Professor adicionado com sucesso.");
    }

    public void removerProfessorPorId(int id) {
        for (Professor professor : professoresCadastrados) {
            if (professor.getId() == id) {
                professoresCadastrados.remove(professor);
                System.out.println("Professor removido com sucesso.");
            }
        }
    }

    public Professor getProfessorPorId(int id) {
        for (Professor professor : professoresCadastrados) {
            if (professor.getId() == id) {
                return professor;
            }
        }
        System.out.println("Nenhum Professor encontrado com o ID informado.");
        return null;
    }
}
