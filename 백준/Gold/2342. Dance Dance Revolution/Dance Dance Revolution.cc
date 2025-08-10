#include<iostream>
#include<vector>
#include<utility>
#include<climits>

using namespace std;
vector<int> cmd;
int sizee;
void input() {
    int temp;
    while (cin >> temp && temp != 0) {
        cmd.push_back(temp);
    }
    sizee = cmd.size();
}
int cost(int a,int b) {
    if (a == b) return 1;           // 같은 지점 다시 밟기
    if (a == 0) return 2;           // 중앙 -> 패널
    if (abs(a - b) == 2) return 4;  // 정반대 (1<->3, 2<->4)
    return 3;

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    input();
    const int INF = 1e9;
    // dp[l][r]: 현재까지의 최소 힘
    vector<vector<int>> dp(5, vector<int>(5, INF));
    dp[0][0] = 0;
    for (int s : cmd) {
        vector<vector<int>> ndp(5, vector<int>(5, INF));
        for (int l = 0; l < 5; ++l) {
            for (int r = 0; r < 5; ++r) {
                if (dp[l][r] == INF) continue; // 아직방문하지 않은 곳
                // 분기 1) 왼발로 s
                ndp[s][r] = min(ndp[s][r], dp[l][r] + cost(l, s));
                // 분기 2) 오른발로 s
                ndp[l][s] = min(ndp[l][s], dp[l][r] + cost(r, s));
            }
        }
        dp.swap(ndp); // 다음 단계로 롤링
    }

    int ans = INF;
    for (int l = 0; l < 5; ++l)
        for (int r = 0; r < 5; ++r)
            ans = min(ans, dp[l][r]);

    cout << ans << '\n';
    return 0;
}
/*
 * 중앙에 있던 발이 다른 지점으로 움직일 때, 2의 힘을 사용하게 된다. 그리고 다른 지점에서 인접한 지점으로 움직일 때는 3의 힘을 사용하게 된다. (
 * 예를 들면 왼쪽에서 위나 아래로 이동할 때의 이야기이다.) 그리고 반대편으로 움직일때는 4의 힘을 사용하게 된다.
 * (위쪽에서 아래쪽으로, 또는 오른쪽에서 왼쪽으로). 만약 같은 지점을 한번 더 누른다면, 그때는 1의 힘을 사용하게 된다.
 *
 */
