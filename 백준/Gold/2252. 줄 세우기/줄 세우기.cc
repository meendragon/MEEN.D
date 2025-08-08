#include<iostream>
#include<vector>
#include<queue>
using namespace std;
vector<int> indegree;
vector<vector<int>> graph;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n,m;
    cin >> n >> m;
    indegree.resize(n+1,0);
    graph.resize(n+1);

    for (int i = 0;i<m;i++) {
        int a,b; cin >> a >> b;
        graph[a].push_back(b);
        indegree[b]++;
    }
    queue<int> q;
    for (int i = 1;i<=n;i++) {
        if (indegree[i] == 0) {
            q.push(i);
        }
    }
    vector<int> ans;
    while (!q.empty()) {
        int cur = q.front();
        ans.push_back(cur);
        q.pop();
        for (int i = 0;i<graph[cur].size();i++) {
            int next = graph[cur][i];
            if (--indegree[next]==0) {
                q.push(next);
            }
        }
    }
    for (int i = 0;i<ans.size();i++) {
        cout << ans[i] << ' ';
    }
    return 0;
}