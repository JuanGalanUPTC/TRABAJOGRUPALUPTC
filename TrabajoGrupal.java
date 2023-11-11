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
            switch (op) {
                case 1:
                    System.out.println("Porfavor ingresa cualquier texto");
                    String texto = sc.nextLine();
                    String nombrePropio = convertidorNombrePropio(texto);
                    System.out.println(nombrePropio);
                default:
                    System.out.println("Opción no valida");
            }  
    }

    public static String convertidorNombrePropio(String texto){
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

}
