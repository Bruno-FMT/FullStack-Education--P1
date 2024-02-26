package dados;

import objetos.funcionarios.Professor;

import java.util.ArrayList;

public class DadosProfessores {
    private static ArrayList<Professor> professoresCadastrados = new ArrayList<>();

    public static ArrayList<Professor> getProfessoresCadastrados() {
        return professoresCadastrados;
    }

    public static Professor getProfessorPorId(int id) {
        try {
            return professoresCadastrados.get(id);
        } catch (Exception e){
            throw new IllegalArgumentException("Nenhum Professor encontrado com o id informado.", e);
        }
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
        DadosCursos.excluirProfessor(getProfessorPorId(id));
        professoresCadastrados.remove(id);
    }

    public static void removerProfessor(Professor professor) {
        if(!professoresCadastrados.contains(professor)) {
            throw new IllegalArgumentException("Professor não encontrado.");
        }
        DadosCursos.excluirProfessor(professor);
        professoresCadastrados.remove(professor);
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
        System.out.println("PROFESSORES CADASTRADOS");
        for (Professor professor : professoresCadastrados) {
            System.out.println("ID: " + professor.getId() + ", Professor:" + professor.toString());
        }
    }
}