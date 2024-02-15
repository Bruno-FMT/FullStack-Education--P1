package objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {

    private String nome;
    private int idade;

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
