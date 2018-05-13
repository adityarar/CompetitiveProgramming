#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <climits>
using namespace std;

int myMax = INT_MAX;
int arr[3002][3002];
void find();

int main() {
    ios_base::sync_with_stdio(false);
    int q,i;
    cin>>q;
    for(i=0;i<q;i++){
        find();
        cout<<endl;
    }
    
    return 0;
}

void find(){
    int n, m , p, q, s, start;
    int dist[3002];
    int visited[3002] = {0};
    cin>>n>>m;
    for(int i=0;i<=n;i++){
        for(int j=0;j<=n;j++){
            arr[i][j] = 0;
        }
    }
    for(int i =0;i<m;i++){
        cin>>p>>q>>s;
        if(arr[p][q]==0 || arr[p][q]>s){
            arr[p][q] = s;
            arr[q][p] = s;
        }
    }
    cin>>start;
    for(int i = 1;i<=n;i++){
        dist[i] = myMax;
    }
    dist[start] = 0;
    for(int i=1 ; i<=n ; i++){
        int minDist = myMax;
        int minNode = start;
        int found = 0;
        for(int j=1 ; j<=n ; j++){
            if(dist[j] < minDist && visited[j]==0){
                minDist = dist[j];
                minNode = j;
                found = 1;
            }
        }
        if(found == 0)//to prevent the case of diconnected graph
            break;
        visited[minNode] = 1;
        for(int j=1 ; j<=n ; j++){
            if(visited[j]==0 && arr[minNode][j]!=0){
                int tempDist = dist[minNode]+arr[j][minNode];
                if(dist[j] > tempDist){
                    dist[j] = tempDist;
                }
            }
        }
    }
    for(int i=1;i<=n;i++){
        if(i==start)
            continue;
        if(dist[i] == myMax)
            cout<<"-1 ";
        else
            cout<<dist[i]<<" ";
    }
}



