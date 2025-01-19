#include<iostream>
#include<vector>
#include<stack>
#include<queue>
#include<string>
#include<utility>
#include<map>
#include<algorithm>
#include<cmath>
#include<bitset>
#include<set>
#include<limits.h>
#define tp tuple<int,int,int>
#define pp pair<int, int>
using namespace std;
int n,m;
vector<vector<pp>> route;
vector<pp> v;
int bfs(int i){
    queue<int> q;
    q.push(i);
    v[i].first = 1;
    while(!q.empty()){
        int front = q.front();
        q.pop();
        for(int j=0;j<route[front].size();j++){
            int next_node = route[front][j].first;
            int next_bool = v[next_node].first;
            int weight = route[front][j].second;
            if(next_bool==0){
                v[next_node].first = 1;
                v[next_node].second=v[front].second+weight;
                q.push(next_node);
            }
        }
    }
    int maxx = 0;
    for(int j = 1;j<=n;j++){
        maxx = max(v[j].second,maxx);
    }
    return maxx;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;
    route.resize(n+1);
    
    for(int i = 1;i<n;i++){
        int a,b,c;
        cin >> a >> b >> c;
        route[a].push_back({b,c});
        route[b].push_back({a,c});
    }
    int maxx = 0;
    for(int i = 1;i<=n;i++){
        v.clear();
        v.resize(n+1);
        if(route[i].size()==1){
            maxx = max(bfs(i),maxx);
        }
    }
    cout << maxx << '\n';
    return 0;
}

