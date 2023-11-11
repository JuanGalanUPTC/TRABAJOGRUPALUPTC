import java.util.Scanner;

public class Egolatra {

    public static void main(String[] args) {
       
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
}