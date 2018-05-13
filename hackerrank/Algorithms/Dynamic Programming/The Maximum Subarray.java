import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- !=0){
            int n =sc.nextInt();
            int arr[] =new int[n];
            int j=0,k=n;
            while((n-- !=0))
                arr[j++]=sc.nextInt();
            //System.out.println(Arrays.toString(arr));
            Solution.find(arr,k);
        }
    }
    public static void find(int arr[],int n){
        int max = Integer.MIN_VALUE;
        int currSum =0;
        int nonConSum =0;
        boolean flag = false;
        int highest=arr[0];
        for(int i=0;i<n;i++){
            //finding lowest for all -ves case
            if(arr[i]>highest)
                highest = arr[i];
            if(arr[i]>0){
                flag =true;
                nonConSum +=arr[i];
            }
            currSum+=arr[i];
            if(currSum>max)
                max = currSum;
            if(currSum<0)
                currSum =0;
        }
        if(! flag){   //all negatives
            nonConSum = highest;
        }
        System.out.println(max+" "+nonConSum);
    }
}