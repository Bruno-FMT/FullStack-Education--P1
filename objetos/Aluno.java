package objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {

    private String nome;
    private int idade;
    private ArrayList<String> cursoMatriculado = new ArrayList<>();

    public Aluno(){
        Scanner input = new Scanner(System.in);
        System.out.print("Aluno precisa ter um nome: ");
        this.nome = input.nextLine();
    }

    public Aluno(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0 || idade > 120)
            throw new IllegalArgumentException("Idade deve estar entre 0-120");
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarCurso(String curso){
        this.cursoMatriculado.add(curso);
    }

    public void removerCurso() {
        Scanner input = new Scanner(System.in);

        listarCursos();
        System.out.print("\nInforme o indice do curso para remover: ");
        try {
            cursoMatriculado.remove(Integer.parseInt(input.nextLine()) - 1);
        } catch (IndexOutOfBoundsException erro){
            System.out.println(erro.getMessage());
        }
    }

    public void listarCursos(){

        int contIndice = 1;

        if (cursoMatriculado.isEmpty()){
            System.out.println("Aluno não está matriculado em nenhum curso");
        } else {
            System.out.printf("| %2s | %14s |\n", "ID", "Nome do Curso");
            for (String curso: cursoMatriculado){
                System.out.printf("| %2d | %14s |\n",contIndice, curso);
                contIndice++;
            }
        }
    }
    @Override
    public String toString(){
        System.out.printf("| %13s | %6s |\n", "Nome", "Idade");
        return String.format(
                "| %13s | %6d |",
                this.getNome(),
                this.getIdade()
        );
    }
}
