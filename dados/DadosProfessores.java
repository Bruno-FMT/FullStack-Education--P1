package dados;

import enums.NiveisCargoFuncionario;
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

    public static void removerProfessor(Professor professor) {
        if (professoresCadastrados.contains(professor)) {
            DadosCursos.excluirProfessor(professor);
            professoresCadastrados.remove(professor);
            System.out.println("Professor removido com sucesso.");
        } else {
            System.out.println("Nenhum Professor encontrado com o id informado.");
        }
    }

    public static void listarTodosProfessoresComId() {
        System.out.println("Todos os professores cadastrados");
        for (Professor professor : professoresCadastrados) {
            System.out.println(
                    "Id: " + professor.getId() +
                    " - Nome: " + professor.getNome() +
                    ", Idade: " + professor.getIdade() +
                    ", Salário: " + professor.getSalario() +
                    ", Status: " + professor.getNivelCargo()
            );
        }
    }

    public static void listarProfessoresPorNivel(NiveisCargoFuncionario nivel) {
        System.out.println("Professores com nível " + nivel);
        for (Professor professor : professoresCadastrados) {
            if (professor.getNivelCargo().equals(nivel)) {
                System.out.println(
                        "Id: " + professor.getId() +
                        " - Nome: " + professor.getNome() +
                        ", Idade: " + professor.getIdade() +
                        ", Salário: " + professor.getSalario() +
                        ", Status: " + professor.getNivelCargo()
                );
            }
        }
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

    public static ArrayList<Professor> getProfessoresPorNivelCargo(NiveisCargoFuncionario nivel) {
        ArrayList<Professor> professores = new ArrayList<>();
        for (Professor professor : professoresCadastrados) {
            if (professor.getNivelCargo().equals(nivel)) {
                professores.add(professor);
            }
        }
        return professores;
    }
}
