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
#include<stdlib.h>
#include<time.h>
#include<limits.h>
#define tp tuple<int,int,int>
#define pp pair<int, int>
using namespace std;
int N,M;
vector<int> link;
vector<vector<int>> graph;
int bfs(){
    int cnt = 0;
    queue<int> q;
    for(int i = 1;i<=N;i++){
        if(link[i]==0){
            cnt++;
            q.push(i);
            while(!q.empty()){
                int now = q.front();
                q.pop();
                for(int j = 0;j<graph[now].size();j++){
                    if(link[graph[now][j]]==0){
                        link[graph[now][j]] = 1;
                        q.push(graph[now][j]);
                    }
                }
            }
        }
    }
    return cnt;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> N >> M;
    link.resize(N+1,0);
    graph.resize(N+1);
    for(int i = 0;i<M;i++){
        int a,b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
    cout << bfs() << '\n';
    return 0;
}
    

