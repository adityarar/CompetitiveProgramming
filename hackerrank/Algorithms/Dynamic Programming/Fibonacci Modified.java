import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    long a,b,n;
    long ans=0;
    Scanner sc =new Scanner(System.in);
    a=sc.nextInt();
    b=sc.nextInt();
    n=sc.nextInt();
    BigInteger bg1 = BigInteger.valueOf(a);
    BigInteger bg2 = BigInteger.valueOf(b);
    BigInteger bg3 = new BigInteger("0");
    n=n-2;
    for(int i=0;i<n;i++){
        BigInteger temp=bg2.multiply(bg2);
        bg3=bg1.add(temp);
        //System.out.println(bg3);
        bg1=bg2;
        bg2=bg3;
    }
    System.out.println(bg3);
    }
}