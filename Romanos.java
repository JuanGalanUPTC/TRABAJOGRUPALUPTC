import java.util.*;
public class Convert  {
    
    private static final int [] num={ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String [] rom={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    
    public static String ConvertNumToRom(int num1){
        if (num1<1 || num1>3000){
          
            throw new IllegalArgumentException("El número debe estar entre 1 y 3000.");
        }

        StringBuilder res= new StringBuilder();
        for (int i=0; i<num.length;i++){
            while (num1>=num [i]){
                res.append(rom[i]);
                num1-=num[i];
            }
        }
        return res.toString();
    }



    public static void main (String... args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese un número entre 1 y 3000");
        int num1= sc.nextInt();
        try {
            String numRom =Convert.ConvertNumToRom(num1);
            System.out.println("El número "+" en números romanos es: "+ numRom);

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());

        }
        sc.close(); 
    }


    
}
