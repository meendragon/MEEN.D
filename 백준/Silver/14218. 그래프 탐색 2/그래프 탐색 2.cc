#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n, m, q;
vector<vector<int>> graph;

vector<int> bfs(int start) {
    vector<int> dist(n + 1, -1);
    queue<int> que;
    que.push(start);
    dist[start] = 0; // 방문 도시 수 (자기 자신 포함)

    while (!que.empty()) {
        int cur = que.front(); que.pop();
        for (int nxt : graph[cur]) {
            if (dist[nxt] == -1) {
                dist[nxt] = dist[cur] + 1;
                que.push(nxt);
            }
        }
    }
    return dist;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;
    graph.resize(n + 1);

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    cin >> q;
    while (q--) {
        int i, j;
        cin >> i >> j;

        // 도로 추가
        graph[i].push_back(j);
        graph[j].push_back(i);

        // BFS 실행
        vector<int> dist = bfs(1);

        // 결과 출력
        for (int k = 1; k <= n; k++) {
            cout << dist[k] << ' ';
        }
        cout << '\n';
    }
    return 0;
}