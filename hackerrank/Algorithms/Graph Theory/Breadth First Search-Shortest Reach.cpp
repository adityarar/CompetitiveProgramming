#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int arr[1001][1001];
int dist[1001];
int front,rear;
int que[10000];
void solve();

void init(){
    for(int i=0;i<1001;i++){
        for(int j=0;j<1001;j++){
            arr[i][j] = 0;
        }
    }
    for(int i =0;i<1001;i++)
        dist[i]=2000;
    rear = -1;
    front = 0;
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int q;
    cin>>q;
    for(int i=0;i<q;i++){
        init();
        solve();
    }
    return 0;
}

void push(int node){
    rear++;
    que[rear] = node;
}

int pop(){
    int x = que[front];
    front++;
    return x;
}

void solve(){
    
    int n,m,p,q,start;
    cin>>n>>m;
    for(int i =0;i<m;i++){
        cin>>p>>q;
        arr[p][q] = 1;
        arr[q][p] = 1;
    }
    cin>>start;
    dist[start] = 0;
    push(start);
    while(rear>=front){
        int cnode = pop();
        for(int i =1;i<=n;i++){
            if(arr[cnode][i] == 1){//if there is a path from current node to i
                if(dist[cnode]+1 < dist[i]){
                    dist[i] = dist[cnode] + 1;
                    push(i);
                }
            }
        }
    }
    for(int i =1;i<=n;i++){
        if(i==start)
            continue;
        if(dist[i] == 2000)
            cout<<"-1 ";
        else
            cout<<dist[i]*6<<" ";
    }
    cout<<endl;
}