import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Primos {
    
    public static List<Integer> primeNum(int num) {
        List<Integer> fp = new ArrayList<Integer>();
        int div = 2;
        
        while (num > 1) {
            if (num % div == 0) {
                fp.add(div);
                num = num / div;
            } else {
                div++;
            }
        }
        
        return fp;
    }
    
    public static String view(List<Integer> fp1) {
        StringBuilder res = new StringBuilder();
        
        int fc = fp1.get(0);
        int exp = 1;
        
        for (int i = 1; i < fp1.size(); i++) {
            if (fp1.get(i) == fc) {
                exp++;
            } else {
                res.append(fc);
                if (exp > 1) {
                    res.append("^").append(exp);
                }
                res.append(" * ");
                fc = fp1.get(i);
                exp = 1;
            }
        }
        
        res.append(fc);
        if (exp > 1) {
            res.append("^").append(exp);
        }
        
        return res.toString();
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número entero positivo: ");
        int numero = sc.nextInt();
        
        List<Integer> fp2 = Primos.primeNum(numero);
        String resultado = Primos.view(fp2);
        
        System.out.println("Los factores primos de " + numero + " son: " + fp2);
        System.out.println("La expresión en formato de potencias es: " + resultado);
        
        sc.close();
    }
    
}
