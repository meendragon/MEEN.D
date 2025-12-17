#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    long long n; cin >> n;
    vector<vector<long long>> dp;
    dp.resize(3);
    for (long long i = 0;i<3;i++) {
        dp[i].resize((n+1));
    }
    vector<long long> wine;
    wine.resize(n+1);
    for (long long i = 0;i<n;i++) {
        long long temp;
        cin >> temp;
        wine[i+1] = temp;
    }
    if (n==1) cout << wine[1];
    else if (n==2) cout << wine[1] + wine[2];
    else {
        dp[0][1] = 0; dp[1][1] = wine[1]; dp[0][2] = wine[1]; dp[1][2] = wine[2]; dp[2][2] = wine[1]+wine[2];
        for (long long i = 3;i<=n;i++) {

            dp[0][i] = max(dp[0][i-1],dp[1][i-1]);
            dp[0][i] = max(dp[0][i],dp[2][i-1]);
            dp[1][i] = dp[0][i-1] + wine[i];
            dp[2][i] = dp[1][i-1] + wine[i];

        }
        long long max = 0;
        for (long long i = 0;i<3;i++) {
            if (dp[i][n] > max) max = dp[i][n];
        }
        cout << max;
    }
    return 0;
}