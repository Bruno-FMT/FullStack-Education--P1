package dados;

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
        if(id < 0 || id > professoresCadastrados.size()) {
            throw new IllegalArgumentException("Nenhum Professor encontrado com o id informado.");
        }
        professoresCadastrados.remove(id);
    }

    public static Professor getProfessorPorId(int id) {
        if(id < 0 || id > professoresCadastrados.size()) {
            throw new IllegalArgumentException("Nenhum Professor encontrado com o id informado.");
        }
        return professoresCadastrados.get(id);
    }

    private static boolean professorEhCadastrado(Professor professor) {
        for (Professor professorCadastrado : professoresCadastrados) {
            if (professorCadastrado.getUsuario().equals(professor.getUsuario())) {
                return true;
            }
        }
        return false;
    }

    public static Professor getProfessorPorUsuario(String usuario) {
        for (Professor professor : professoresCadastrados) {
            if (professor.getUsuario().equals(usuario)) {
                return professor;
            }
        }
        return null;
    }
}
