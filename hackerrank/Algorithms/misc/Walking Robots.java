
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    

    static int howManyCollisions(String s){
        // Complete this function
        int total = 0;
        int cf = -1;
        int rightCount = 0;
        char[] robots = s.toCharArray();
        for(char ch : robots){
            if(ch == 'r'){
                cf = 1;
                rightCount ++;
            }
            else if(ch == 'd'){
                cf = 0;
                total += rightCount;
                rightCount = 0;
            }
            else{
                if(cf == 1){
                	total += rightCount;
            		total ++;
                    cf = 0;
                    rightCount = 0;
                    continue;
                }
                else if(cf == 0){
                    total += 1;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            // Returns the number of times moving robots collide.
            int result = howManyCollisions(s);
            System.out.println(result);
        }
    }
}
