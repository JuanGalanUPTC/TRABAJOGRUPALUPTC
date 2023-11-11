import java.util.*;

public class Magico {
    public static void main(String[] args) {
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
