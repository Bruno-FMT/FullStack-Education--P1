import objetos.Aluno;
import util.PedirEntrada;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class Display { //TODO: Utilizar métodos como parâmetro para reutilizar código de definirNome, definirIdade etc...
    //TODO: Aprender a suportar métodos com parâmetros e com parâmetros diferentes

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, ClassNotFoundException {

        boolean continuar = true;
        Scanner scan = new Scanner(System.in);
        Aluno aluno = new Aluno();
        Method metodo = transformarMetodo(aluno, "setNome", String.class);
        if (!definirAtributoConta(scan, aluno, metodo)) {}
        else if (!definirAtributoConta(scan, aluno, transformarMetodo(aluno, "setIdade", int.class))) {}
        else if (!definirAtributoConta(scan, aluno, transformarMetodo(aluno, "setUsuario", String.class))) {}
        else if (!definirAtributoConta(scan, aluno, transformarMetodo(aluno, "setSenha", String.class))) {}

        System.out.println("Continuar: " + continuar);
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println("Usuario: " + aluno.getUsuario());
        System.out.println("Senha: " + aluno.getSenha());
        System.out.println();

    }

    public static boolean testeDefinir(String nome) {
        System.out.println("Rodou testeDefinir()");
        return false;
    }

    public static void staticteste() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Class<?> classe = Class.forName("Display");
        java.lang.reflect.Method method = classe.getDeclaredMethod("testing");
        methodTest(method);
    }

    public void teste() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        java.lang.reflect.Method method;
        method = this.getClass().getMethod("testing");
        methodTest(method);

    }

//    public void testing() {
//        System.out.println("Hello World!");
//    }
//
//    public static void methodTest(Consumer<Display> myMethod) {
//        myMethod.accept(null);
//    }

    public static void testing() {
        System.out.println("Hello world!");
    }

    public static void methodTest(Method method) throws InvocationTargetException, IllegalAccessException {
        method.invoke(null);
    }


    public static void criarConta(ArrayList<Method> metodos) throws InvocationTargetException, IllegalAccessException {
        for (Method metodo : metodos) {
            metodo.invoke(null);
        }
    }

    // TODO: Aceitar passagem de Classe para achar o método. Retornar métodow
    public static Method transformarMetodo(Object objeto, String nomeMetodo, Class<?>... parametros) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //        definirAtributoConta(metodo, objeto);
        return objeto.getClass().getDeclaredMethod(nomeMetodo, parametros); //Pega a classe do objeto, e pesquisa o método pelo nome
    }

    // TODO: Aceitar String como parâmetro para o display do tipo de dado (nome do dado)
    public static boolean definirAtributoConta(Scanner scan, Object objeto, Method metodo) throws InvocationTargetException, IllegalAccessException {
        System.out.print("Digite seu nome: ");
        while (true) {

            Class<?>[] parametrosTipos = metodo.getParameterTypes();
            Object[] argumentos = new Object[parametrosTipos.length];
            for (int i = 0; i < parametrosTipos.length; i++) {

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

//            if (Boolean.getBoolean(metodo.invoke(null) ? "true" : "false")) {
//                return;
//            }
            System.out.println(metodo.getParameters()[0].toString() +"Nome inválido.");

            System.out.println("Quer continuar? [s/n]");
            if (!PedirEntrada.pedirBoolean(scan)) {
                return false;
            }

            System.out.print("Digite um nome válido: ");
        }
    }
}
