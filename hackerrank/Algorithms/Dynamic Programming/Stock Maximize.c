#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>


void finder(int days){
    long int arr[50000];
    for(int i=0;i<days;i++)
        scanf("%lu",&arr[i]);
    long int profit=0;
    long int currPrice;
    int pos=-1;
    for(int i=0;i<days;i++){
        currPrice=arr[i];
        //finding if we have better price in future(we find best price in future), if yes then we buy
        int better=0;
        long int best=-1;
        for(int j=i+1;j<days;j++){
            //int currentBest=-1 ;
            //we find the last date on which we have the best result
            if(arr[j]>currPrice && arr[j]>=best){
                better=1;   // found;
                //printf("found better at %d with val=%d\n",j,arr[j]);
                best=arr[j];
                pos=j;  //till this we keep buying
            }
        }
        if(better==1){  //if better is available in future, keep buying till then
            int noOfShares=0;
            //printf("profit = %d",profit);
            while(i!=pos){
                noOfShares++;
                profit=profit-arr[i];
                //printf("profit = %d",profit);
                i++;
            }
            //printf("shares = %d\n",noOfShares);            
            profit=profit+(noOfShares*arr[i]);
            //printf("after buying profit = %d\n",profit);
        }
    }
    printf("%lu\n",profit);
}

int main() {

    /* Enter your code here. Read input from STDIN. Print output to STDOUT */    
    int t;  // no. of test cases
    int days=0;   // no of days that are predicted
    scanf("%d",&t);
    //int deller = 2337671690;
    //printf("val = %d",deller);
    while(t!=0){
        scanf("%d",&days);
        finder(days);
        //printf("%\n",days);
        t--;
    }
    return 0;
}


