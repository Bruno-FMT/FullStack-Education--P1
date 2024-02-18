package util;

import dados.DadosAlunos;
import objetos.Aluno;
import util.PedirEntrada;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class Display {

    public static void displayAluno(Scanner scan, Aluno aluno) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        boolean continuar = true;
        Method metodo = transformarMetodo(aluno, "setNome", String.class);
        if (!definirAtributoConta(scan, aluno, metodo, new String[]{"nome completo"})) {
            continuar = false;
        } else if (!definirAtributoConta(scan, aluno, transformarMetodo(aluno, "setIdade", int.class), new String[]{"idade"})) {
            continuar = false;
        } else if (!definirAtributoConta(scan, aluno, transformarMetodo(aluno, "setUsuario", String.class), new String[]{"usuário"})) {
            continuar = false;
        } else if (!definirAtributoConta(scan, aluno, transformarMetodo(aluno, "setSenha", String.class), new String[]{"senha"})) {
            continuar = false;
        }
        if(continuar) {
            DadosAlunos.adicionarAluno(aluno);
        }
        System.out.println("Continuar: " + continuar);
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println("Usuario: " + aluno.getUsuario());
        System.out.println("Senha: " + aluno.getSenha());
        System.out.println();
    }

    public static void testing() {
        System.out.println("Hello world!");
    }

    public static void methodTest(Method method) throws InvocationTargetException, IllegalAccessException {
        method.invoke(null);
    }

    public static Method transformarMetodo(Object objeto, String nomeMetodo, Class<?>... parametros) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Pega a classe do objeto, e pesquisa o método pelo nome
        return objeto.getClass().getDeclaredMethod(nomeMetodo, parametros);
    }

    public static boolean definirAtributoConta(Scanner scan, Object objeto, Method metodo, String[] parametrosNome) throws InvocationTargetException, IllegalAccessException {

        while (true) {
            Class<?>[] parametrosTipos = metodo.getParameterTypes();
            Object[] argumentos = new Object[parametrosTipos.length];

            for (int i = 0; i < parametrosTipos.length; i++) {
                System.out.print("Digite seu/sua " + parametrosNome[i] + ": ");
                if (parametrosTipos[i].equals(String.class)) {
                    argumentos[i] = PedirEntrada.pedirString(scan);
                } else if (parametrosTipos[i].equals(char.class)) {
                    argumentos[i] = PedirEntrada.pedirChar(scan);
                } else if (parametrosTipos[i].equals(boolean.class)) {
                    argumentos[i] = PedirEntrada.pedirBoolean(scan);
                } else if (parametrosTipos[i].equals(byte.class)) {
                    argumentos[i] = PedirEntrada.pedirByte(scan);
                } else if (parametrosTipos[i].equals(short.class)) {
                    argumentos[i] = PedirEntrada.pedirShort(scan);
                } else if (parametrosTipos[i].equals(int.class)) {
                    argumentos[i] = PedirEntrada.pedirInt(scan);
                } else if (parametrosTipos[i].equals(long.class)) {
                    argumentos[i] = PedirEntrada.pedirLong(scan);
                } else if (parametrosTipos[i].equals(float.class)) {
                    argumentos[i] = PedirEntrada.pedirFloat(scan);
                } else if (parametrosTipos[i].equals(double.class)) {
                    argumentos[i] = PedirEntrada.pedirDouble(scan);
                }
            }
            //  Método invoke retorna um Object, portanto não pode ser usado diretamente.
            //  Porém, ao igualar a true com equals(), estará boolean
            if (metodo.invoke(objeto, argumentos).equals(true)) {
                System.out.println("Quer continuar? [s/n]");
                return PedirEntrada.pedirBoolean(scan); // retorna o boolean do scan
            }

            System.out.println("Entrada(s) inválida(s).");

            System.out.println("Quer continuar? [s/n]");
            if (!PedirEntrada.pedirBoolean(scan)) {
                return false;
            }

//            System.out.print("Digite um(a) "+ parametrosNome[i] +" válido(a): ");
        }
    }
}
