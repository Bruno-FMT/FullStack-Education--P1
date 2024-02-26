package util;

import java.util.Scanner;

public class PedirEntrada {
    public static String pedirString(Scanner scan) {
        return scan.nextLine();
    }

    public static char pedirChar(Scanner scan) {
        String input = scan.nextLine();
        return input.charAt(0);
    }

    public static boolean pedirBoolean(Scanner scan) {
        String entrada = scan.nextLine();
        if (entrada.isEmpty()) {
            return true;
        }
        return switch (entrada.toLowerCase().charAt(0)) {
            case 'f', 'n', '0' -> false;
            default -> true;
        };
    }

    public static byte pedirByte(Scanner scan) {
        byte resultado;
        while (true) {
            try {
                resultado = Byte.parseByte(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erro de digitação (pedindo byte)");
                System.out.print("Tente um número inteiro (entre -128 e 127): ");
            }
        }
        return resultado;
    }

    public static short pedirShort(Scanner scan) {
        short resultado;
        while (true) {
            try {
                resultado = Short.parseShort(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erro de digitação (pedindo short)");
                System.out.print("Tente um número inteiro (entre -32768 e 32767): ");
            }
        }
        return resultado;
    }

    public static int pedirInt(Scanner scan) {
        int resultado;
        while (true) {
            try {
                resultado = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erro de digitação (pedindo int)");
                System.out.print("Tente um número inteiro (entre -2147483648 e 2147483647): ");
            }
        }
        return resultado;
    }

    public static long pedirLong(Scanner scan) {
        long resultado;
        while (true) {
            try {
                resultado = Long.parseLong(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erro de digitação (pedindo long)");
                System.out.print("Tente um número inteiro (entre -9223372036854775808 e 9223372036854775807): ");
            }
        }
        return resultado;
    }

    public static float pedirFloat(Scanner scan) {
        float resultado;
        while (true) {
            try {
                resultado = Float.parseFloat(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erro de digitação (pedindo float)");
                System.out.print("Tente um número decimal: ");
            }
        }
        return resultado;
    }

    public static double pedirDouble(Scanner scan) {
        double resultado;
        while (true) {
            try {
                resultado = Double.parseDouble(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Erro de digitação (pedindo double)");
                System.out.print("Tente um número decimal: ");
            }
        }
        return resultado;
    }

}
