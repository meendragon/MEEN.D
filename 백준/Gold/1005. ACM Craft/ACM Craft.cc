#include<iostream>
#include<vector>
#include<queue>

using namespace std;
int N,K,T,W;
vector<int> taken_time;
vector<vector<int>> v;
vector<int> dp;
vector<int> indegree;
int main() {
    ios_base::sync_with_stdio(NULL);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cin >> T;
    for (int i = 0;i<T;i++) {
        cin >> N >> K;
        taken_time.resize(N+1);
        dp.resize(N+1);
        indegree.resize(N+1);
        v.resize(N+1);
        for (int j = 1;j<=N;j++) {
            cin >> taken_time[j];
        }
        for (int j = 1;j<=K;j++) {
            int a,b;
            cin >> a >> b;
            v[a].push_back(b);
            indegree[b]++;
        }
        cin >> W;
        queue<int> q;
        for (int j = 1;j<=N;j++) {
            if (indegree[j] == 0) {
                q.push(j);
                dp[j] = taken_time[j];
            }
        }
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            for (int j = 0;j<v[cur].size();j++) {
                int next = v[cur][j];
                if (next>0) {
                    dp[next] = max(dp[next],dp[cur]+taken_time[next]);
                    if (--indegree[next] == 0) {//이게 0이되면 더이상 여기로 들어올일이없어서 이제 부터 픽스
                        q.push(next);
                    }
                }
            }
        }
        cout << dp[W] << endl;
        taken_time.clear();
        dp.clear();
        indegree.clear();
        v.clear();


    }

}