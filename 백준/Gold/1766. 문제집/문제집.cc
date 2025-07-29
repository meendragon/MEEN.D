#include<iostream>
#include<vector>
#include<queue>
#include<utility>
using namespace std;

vector<int> degree;
vector<vector<int>> graph;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n,m;
    cin >> n >> m;
    graph.resize(n+1,vector<int>());
    degree.resize(n+1,0);

    for (int i = 0;i<m;i++) {
        int a,b;
        cin >> a >> b;
        graph[a].push_back(b);
        degree[b]++;
    }
    priority_queue<int,vector<int>, greater<int>> pq;
    for (int i = 1;i<=n;i++) {
        if (degree[i] == 0) {
            pq.push(i);
        }
    }
    while (!pq.empty()) {
        int cur  = pq.top();
        pq.pop();
        cout << cur << ' ';
        for (int j = 0;j<graph[cur].size();j++) {
            degree[graph[cur][j]]--;
            if (degree[graph[cur][j]] == 0) {
                pq.push(graph[cur][j]);
            }
        }
    }





    return 0;
}