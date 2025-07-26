#include<iostream>
#include<vector>
#include<queue>
#include<cmath>
using namespace std;
int n,m;
vector<int> parent;
int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
}
bool unionSet(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) return false;
    parent[b] = a;
    return true;
}
class Route {
public:
    int start, end, cost;
    Route(int start, int end, int cost):start(start),end(end),cost(cost){}
};
struct CompareRoute {
    bool operator()(const Route& a, const Route& b) {
        return a.cost > b.cost; // 최소 힙
    }
};
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> m;
    parent.resize(n+1);

    for (int i = 1;i<=n;i++) {
        parent[i] = i;
    }

    priority_queue<Route,vector<Route>,CompareRoute> pq;
    for (int i = 0;i<m;i++) {
        int a,b,cost;
        cin >> a >> b >> cost;
        Route temp = Route(a,b,cost);
        pq.emplace(temp);
    }
    int count = 0;
    int cost = 0;
    int maxx = -1;
    while (count!=(n-1)) {
        Route temp = pq.top();
        pq.pop();
        bool addWorked = unionSet(temp.start,temp.end);
        if (addWorked) {
            cost+=temp.cost;
            count++;
            maxx = max(maxx, temp.cost);
        }
    }
    cout << cost-maxx;
    return 0;

}