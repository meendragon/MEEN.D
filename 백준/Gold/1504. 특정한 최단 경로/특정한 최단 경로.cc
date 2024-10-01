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
int N,E,v1,v2;
int weight[801][801];
vector<vector<int>> way;
int f(int s, int tg){
    if(s==tg) return 0;
    vector<int> node(N+1,INT_MAX);
    queue<int> q;
    for(int i = 0;i<way[s].size();i++){
        int next =way[s][i];
        node[next] = weight[s][next];
        q.push(next);
    }//첫 스타팅 노드에서 다음 노드들은 일단 가중치를 넣어놓고 시작
    while(!q.empty()){
        int now = q.front();
        q.pop();
        for(int i = 0;i<way[now].size();i++){
            int next = way[now][i];
            int neo = node[now]+weight[now][next];
            if(node[next]>neo){
                node[next]=neo;
                if(next!=tg){
                    q.push(next);
                }
            }
        }
    }
    return node[tg];
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> N >> E;
    way.resize(N+1);
    for(int i = 0;i<E;i++){
        int a,b,c;
        cin >> a >> b >> c;
        weight[a][b] = c;
        weight[b][a] = c;
        way[a].push_back(b);
        way[b].push_back(a);
    }
    cin >> v1 >> v2;
    long long ans1,ans2;
    ans1 = ans2 = 0;
    int arr1[4] = {1,v1,v2,N};
    int arr2[4] = {1,v2,v1,N};
    for(int i = 0;i<3;i++){
        ans1+=f(arr1[i],arr1[i+1]);
        ans2+=f(arr2[i],arr2[i+1]);
    }
    long long ans = ans1 < ans2 ? ans1:ans2;
    if(ans>=INT_MAX) ans = -1;
    
    cout << ans << '\n';
    return 0;
}
    

