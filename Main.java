import dados.DadosAlunos;
import objetos.Aluno;

import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        new Aluno();
        System.out.println(DadosAlunos.getAlunosCadastrados().size());
        Aluno objeto = DadosAlunos.getAlunoPorId(0);
        System.out.println(objeto);

//        System.out.println("Hello world!");
//        Aluno aluno = new Aluno("João Victor Olivo", 16);
//        aluno.setUsuario("joao");
//        aluno.setSenha("1234567");
//        DadosAlunos.adicionarAluno(aluno);
//        Aluno aluno2 = new Aluno("João Pedro Cabral", 16);
//        aluno2.setUsuario("joao");
//        System.out.println(aluno2.setSenha("4820397593"));
//        DadosAlunos.adicionarAluno(aluno2);
    }
}