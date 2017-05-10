/**
 *
 * @author Joshua Alexander
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ModularMultiplicativeInverseCalc {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter Number: ");
        int num = scan.nextInt();
        
        System.out.print("\nEnter Modulus Number: ");
        int mod = scan.nextInt();
        
        System.out.println("\nModular Inverse of " + num + " mod " + mod + " = " + extendedEuclidean(num, mod));
        
    }
    
    // Finds the modular inverse of a number given the number and the modulus
    private static int extendedEuclidean (int x, int y) {
        int remainder = 1, quotient, p = 0, mod = y;
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> Q = new ArrayList<>();
        
        A.add(0); // add 0 for step p0 to list
        A.add(1); // add 1 for step p1 to list
        
        while (remainder != 0) {
            
            remainder = y % x; // sets the remainder
            quotient = y / x; // sets the quotient (no need to round, int diviision)
            Q.add(quotient); // adds the quotient to the Q list
            
            if(p != 0 && p != 1) { // if loop is not on p0 or p1 steps
                int num = (A.get(p - 2) - (A.get(p - 1) * Q.get(p - 2))) % mod; // calculate the p value for current step
                if (num < 0) { // fix for negative remainder using modulus in java
                    num += mod;
                }
                
                A.add(num); // add the result of pi calculation to the A list
            }
            
            y = x; // set new pq value to e
            x = remainder; // set new e to remainder
            p++; // increment p
        }
            
        int num = (A.get(p - 2) - (A.get(p - 1) * Q.get(p - 2))) % mod; // calculate the p value
        
        if (num < 0) { // fix for negative remainder using modulus in java
            num += mod;
        }
        
        A.add(num); // add the last last p value to the list
        
        return A.get(p);
    }
}
