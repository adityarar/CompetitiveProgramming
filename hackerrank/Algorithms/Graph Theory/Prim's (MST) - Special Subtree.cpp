#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int arr[3002][3002];
int dist[3001] = {0};
int visited[3001] = {0};

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int n,m,p,q,s,start;
    cin>>n>>m;
    for(int i =0;i<=n;i++){
        for(int j = 0;j<=n;j++){
            arr[i][j] = -1;
        }
    }
    for(int i =0;i<m;i++){
        cin>>p>>q>>s;
        arr[p][q] = s;
        arr[q][p] = s;
    }
    cin>>start;
    for(int i = 1;i<=n;i++){
        dist[i] = 0x7FFFFFFF;
    }
    dist[start] = 0;
    for(int i=1;i<=n;i++){//one node is selected per iteration
        int localMin = 0x7FFFFFFF;
        int minNode = start;
        for(int j=1;j<=n;j++){
            if(dist[j]<localMin && visited[j]==0 && dist[j]!=-1){
                localMin = dist[j];
                minNode = j;
            }
        }
        /*
        cout<<"m - "<<minNode<<endl;
        for(int k=1;k<=n;k++){
            cout<<dist[k]<<" ";
        }
        cout<<endl;
        */
        visited[minNode] = 1;
        for(int j=1;j<=n;j++){
            int weight = arr[minNode][j];
            if(weight == -1 || visited[j]==1)
                continue;
            if(weight < dist[j])
                dist[j] = weight;
        }
    }
    
    int edgeSum = 0;
    for(int i=1;i<=n;i++){
        edgeSum += dist[i];
    }
    cout<<edgeSum;
    return 0;
}
