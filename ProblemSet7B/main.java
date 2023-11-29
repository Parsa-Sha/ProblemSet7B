
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;

public class main
{
    public static void main() {
        System.out.println("The prime numbers from 2-50 are as follows: " + eSieve(500));
        System.out.println("Two prime numbers that add up to 66 are " + goldCongee(66)[0] + " & " + goldCongee(66)[1]);
        ArrayList<Integer> c = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();
        
        c.add(9);
        c.add(8);
        c.add(7);
        
        d.add(7);
        d.add(8);
        d.add(9);
        
        System.out.print(c + " + " + d + " = ");
        
        ArrayList<Integer> e = addBigInts(c, d);
        
        System.out.println(e);
    }
    
    public static ArrayList<Integer> eSieve(int n) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 2; i < n; i++) {
            a.add(i);
        }
        
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < a.size(); j++) {
                if (a.get(j) % i == 0 & a.get(j) > i) {
                    a.remove(j);
                    j--; // Coincidentally, this isnt neccisary (no clue how to spell this word) in this code
                }
            }
        }
        
        return a;
    }
    
    public static int[] goldCongee(int n) {
        int[] a = new int[2];
        for (int i = 1; i < n; i++) {
            if (eSieve(n).contains(i) && eSieve(n).contains(n-i)) {
                a[0] = i;
                a[1] = n-i;
                return a;
            }
        }
        
        return a;
    }
    
    public static ArrayList<Integer> addBigInts(ArrayList<Integer> a, ArrayList<Integer> b) { 
        if (a.size() < b.size()) { // Set A to be the larger one
            ArrayList<Integer> temp = b;
            b = a;
            a = temp;
        }
        
        while (a.size() > b.size()) b.add(0, 0); // Set their lengths to be the same (B will have empty 0 slots at higher digits)
        
        for (int i = a.size()-1; i > -1; i--) { // Wow addition
            a.set(i, a.get(i) + b.get(i));
            if (a.get(i) > 9) {
                a.set(i, a.get(i)%10);
                if (i > 0) {
                    a.set(i-1, a.get(i-1) + 1);
                } else { // Exception needed for the first digit to add properly
                    a.add(0, 1);
                }
            }
        }
        
        return a;
    }
    
}
