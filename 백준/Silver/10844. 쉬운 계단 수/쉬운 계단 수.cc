#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
vector<vector<long long>> dp;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n; cin >> n;
    dp.resize(n+1);
    for (int i = 0;i<n+1;i++) {
        dp[i].resize(10,0);
    }
    for (int i = 1;i<=9;i++) {
        dp[1][i] = 1;
    }
    for (int i = 2;i<=n;i++) {
        for (int j = 0;j<=9;j++) {
            if (j-1>=0) {
                dp[i][j] += dp[i-1][j-1]%1000000000;
            }
            if (j+1<=9) {
                dp[i][j] += dp[i-1][j+1]%1000000000;
            }
        }
    }
    long long ans = 0;
    for (int i = 0;i<=9;i++) {
        ans += dp[n][i]%1000000000;
    }
    cout << ans % 1000000000;

    return 0;
}