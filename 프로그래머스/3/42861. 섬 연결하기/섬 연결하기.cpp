#include <string>
#include <vector>
#include <algorithm>

using namespace std;

// 유니온 파인드 (Disjoint Set Union)
int findParent(int x, vector<int> &parent) {
    if (parent[x] == x) return x;
    return parent[x] = findParent(parent[x], parent); // 경로 압축
}

void unionSet(int a, int b, vector<int> &parent) {
    a = findParent(a, parent);
    b = findParent(b, parent);
    if (a < b) parent[b] = a;
    else parent[a] = b;
}

bool isSameSet(int a, int b, vector<int> &parent) {
    return findParent(a, parent) == findParent(b, parent);
}

int solution(int n, vector<vector<int>> costs) {
    // 1. 비용 기준 정렬
    sort(costs.begin(),costs.end(),[](auto &a, auto &b){
        return a[2] < b[2];
    });

    // 2. 유니온파인드 초기화
    vector<int> parent(n);
    for (int i = 0; i < n; i++) parent[i] = i;

    int answer = 0;
    int edgeCount = 0;

    // 3. 싼 간선부터 하나씩 채택
    for (auto &e : costs) {
        int u = e[0];
        int v = e[1];
        int w = e[2];

        if (!isSameSet(u, v, parent)) {
            unionSet(u, v, parent);
            answer += w;
            edgeCount++;
            if (edgeCount == n - 1) break; // MST 완성
        }
    }

    return answer;
}