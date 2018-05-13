#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int arr[100002]={0};
long long int dp[100002];

int myMax(int x, int y){
    return x>y?x:y;
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int n;
    cin>>n;
    for(int i=0;i<n;i++)
        cin>>arr[i];
    for(int i=0;i<n;i++)
        dp[i]=1;
    for(int i=1;i<n;i++){
        if(arr[i]>arr[i-1])
            dp[i] = myMax(dp[i-1]+1,dp[i]);
    }
    for(int i=n-1;i>=0;i--){
        if(arr[i]>arr[i+1])
            dp[i] = myMax(dp[i+1]+1,dp[i]);
    }
    long long sum=0;
    for(int i=0;i<n;i++)
        sum+=dp[i];
    cout<<sum;
    return 0;
}
