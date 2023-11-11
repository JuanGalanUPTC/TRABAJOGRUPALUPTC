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
                System.out.println("Por favor ingresa un número:");
                int num = sc.nextInt();
                egolatra(num);
                break;

            case 5:
                
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

    public static void egolatra(int num) {
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

