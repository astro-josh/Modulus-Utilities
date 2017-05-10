/**
 *
 * @author Joshua Alexander
 */

import java.util.Scanner;

public class ModularExponentiationCalc {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter Number: ");
        int num = scan.nextInt();
        
        System.out.print("\nEnter Exponent: ");
        int exp = scan.nextInt();
        
        System.out.print("\nEnter modulus number: ");
        int mod = scan.nextInt();
        
        System.out.println("\nModular Exponentiation of " + num + " rasied to the " + exp + "power mod " + mod + " = " + modularExponentiation(num, exp, mod));
        
    }
    
    // performs modular exponentiation by continuously calculating the mod after each power evaluation
    private static int modularExponentiation (int num, int exp, int mod) {
        int result = 1;
   
        for (int i = 0; i < exp; i++) { // iterates up to the number of the exp
            result = ((result * num) % mod);
        }
        
        return result;
    }
}
