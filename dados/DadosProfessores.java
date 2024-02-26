package dados;

import objetos.Aluno;
import objetos.funcionarios.Diretor;
import objetos.funcionarios.Professor;

import java.util.ArrayList;
import java.util.List;

public class DadosProfessores {
    private static List<Professor> professoresCadastrados = new ArrayList<>();

    public static List<Professor> getProfessoresCadastrados() {
        return professoresCadastrados;
    }

    public static void adicionarProfessor(Professor professor) {
        if (professorEhCadastrado(professor)) {
            throw new IllegalArgumentException("Professor já cadastrado.");
        }
        professoresCadastrados.add(professor);
    }

    public static void removerProfessorPorId(int id) {
        if (id < 0 || id > professoresCadastrados.size()) {
            throw new IllegalArgumentException("Nenhum Professor encontrado com o id informado.");
        }
        professoresCadastrados.remove(id);
    }

    public static Professor getProfessorPorId(int id) {
        if (id < 0 || id > professoresCadastrados.size()) {
            throw new IllegalArgumentException("Nenhum Professor encontrado com o id informado.");
        }
        return professoresCadastrados.get(id);
    }

    public static Professor getProfessorPorUsuario(String usuario) {
        for (Professor professor : professoresCadastrados) {
            if (professor.getUsuario().equals(usuario)) {
                return professor;
            }
        }
        throw new IllegalArgumentException("Nenhum professor encontrado com o usuário informado.");
    }

    private static boolean professorEhCadastrado(Professor professor) {
        for (Professor professorCadastrado : professoresCadastrados) {
            if (professorCadastrado.getUsuario().equals(professor.getUsuario())) {
                return true;
            }
        }
        return false;
    }

    public static void imprimirListaTodosProfessores() {
        System.out.println("\nPROFESSORES");
        for (Professor professor : professoresCadastrados) {
            System.out.println(
                    "ID: " + professor.getId() +
                    " - Nome: " + professor.getNome() +
                    ", Nível: " + professor.getNivelCargo()
            );
        }
    }
}
