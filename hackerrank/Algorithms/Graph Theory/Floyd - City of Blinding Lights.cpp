#include <cmath>
#include <cstdio>
#include <climits>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int dist[402][402];

int main() {
	int n, m, i, j, k, p, q, r, queries;
	cin >> n >> m;
	for (i = 0; i <= n; i++){
		for (j = 0; j <= n; j++){
			dist[i][j] = INT_MAX;
			if (i == j)
				dist[i][j] = 0;
		}
	}
	for (i = 0; i<m; i++){
		cin >> p >> q >> r;
		dist[p][q] = r;
	}
	for (k = 1; k <= n; k++){
		for (i = 1; i <= n; i++){
			for (j = 1; j <= n; j++){
				if (dist[i][k] != INT_MAX && dist[k][j] != INT_MAX){
					int newDist = dist[i][k] + dist[k][j];
					if (newDist < dist[i][j])
						dist[i][j] = newDist;
				}
			}
		}
	}
	cin >> queries;
	for (i = 0; i<queries; i++){
		cin >> p >> q;
		if (dist[p][q] == INT_MAX)
			cout << "-1" << endl;
		else
			cout << dist[p][q] << endl;
	}
	return 0;
}
