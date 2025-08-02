#include<iostream>
#include <vector>
#include <climits>
using namespace std;

const int INF = 1e9;
int n;
int W[16][16];
int dp[16][1 << 16];

int tsp(int current, int visited) {
    if (visited == (1<<n)-1) {
        if (W[current][0] != 0) {
            return W[current][0];
        }
        else {
            return INF;
        }
    }

    int& ret = dp[current][visited];
    if (ret!=-1) return ret;


    ret = INF;
    for (int next = 0;next<n;++next) {
        if (!(visited & 1 << next)&&W[current][next]!=0) {
            ret = min(ret, tsp(next,visited | (1<<next))+W[current][next]);
        }
    }
    return ret;
}
int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; ++i)
        for (int j = 0; j < n; ++j)
            cin >> W[i][j];


    fill(&dp[0][0], &dp[0][0] + sizeof(dp)/sizeof(int), -1);

    cout << tsp(0, 1 << 0) << '\n'; // 0번 도시에서 시작
    return 0;

}