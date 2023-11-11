import java.util.Arrays;
import java.util.Scanner;

public class TrabajoGrupal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a este Algoritmo, ¿Qué deseas hacer?");
        System.out.println("1.Convertidor de números Romanos");
        System.out.println("2.Factores Números Primos");
        System.out.println("3.Nombre Propio");
        System.out.println("4.Números Ególatras");
        System.out.println("5.Número Mágico");
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                
                break;

            case 2:
                
                break;

            case 3:
                System.out.println("Por favor ingresa cualquier texto:");
                String texto = sc.nextLine();
                String nombrePropio = convertidorNombrePropio(texto);
                System.out.println(nombrePropio);
                break;

            case 4:
                egolatra();
                break;

            case 5:
                magico();
                break;

            default:
                System.out.println("Opción no válida");
        }
    }

    public static String convertidorNombrePropio(String texto) {
        texto = texto.trim();

        String[] palabras = texto.split("\\s+");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            if (palabra.length() > 1) {
                String primeraLetra = palabra.substring(0, 1).toUpperCase();
                String restoPalabra = palabra.substring(1).toLowerCase();
                resultado.append(primeraLetra).append(restoPalabra);
            } else {
                resultado.append(palabra);
            }
        }
        return resultado.toString();
    }

    public static void egolatra() {
        Scanner sc = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Ingrese un número positivo: ");
            while (!sc.hasNextInt()) {
                System.out.println("¡Error! Por favor, ingrese un número entero positivo.");
                sc.next(); 
            }
            numero = sc.nextInt();
            if (numero <= 0) {
                System.out.println("¡Error! Por favor, ingrese un número entero positivo.");
            }
        } while (numero <= 0);

        
        boolean esEgolatra = esNumeroEgolatra(numero);

        
        if (esEgolatra) {
            System.out.println("Verdadero. El número es ególatra.");
        } else {
            System.out.println("Falso. El número no es ególatra.");
        }
    }

    private static boolean esNumeroEgolatra(int numero) {
        int numDigitos = contarDigitos(numero);
        int suma = 0;
        int temp = numero;

        while (temp > 0) {
            int digito = temp % 10;
            suma += Math.pow(digito, numDigitos);
            temp /= 10;
        }

        return suma == numero;
    }

    private static int contarDigitos(int numero) {
        int count = 0;
        
        while (numero != 0) {
            numero /= 10;
            count++;
        }

        return count;
    }

    public static void magico(){
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            System.out.print("Ingresa un número entero: ");
            while (!sc.hasNextInt()) {
                System.out.print("Por favor, ingresa un número entero válido: ");
                sc.next();
            }
            numero = sc.nextInt();
        } while (numero <= 0);

        boolean esMagico = esNumeroMagico(numero);
        System.out.println("El número " + numero + " es mágico: " + esMagico);
    }

    public static boolean esNumeroMagico(int numero) {
        String numeroStr = String.valueOf(numero);
        int[] digitos = obtenerDigitos(numeroStr);

        int numeroAscendente = obtenerNumeroAscendente(digitos);
        int numeroDescendente = obtenerNumeroDescendente(digitos);
        int resta = numeroDescendente - numeroAscendente;

        return resta == numero;
    }

    public static int[] obtenerDigitos(String numeroStr) {
        int[] digitos = new int[numeroStr.length()];
        for (int i = 0; i < numeroStr.length(); i++) {
            digitos[i] = Integer.parseInt(String.valueOf(numeroStr.charAt(i)));
        }
        return digitos;
    }

    public static int obtenerNumeroAscendente(int[] digitos) {
        Arrays.sort(digitos);
        return obtenerNumero(digitos);
    }

    public static int obtenerNumeroDescendente(int[] digitos) {
        Arrays.sort(digitos);
        reverseArray(digitos);
        return obtenerNumero(digitos);
    }

    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static int obtenerNumero(int[] digitos) {
        StringBuilder sb = new StringBuilder();
        for (int digito : digitos) {
            sb.append(digito);
        }
        return Integer.parseInt(sb.toString());
    }
}
