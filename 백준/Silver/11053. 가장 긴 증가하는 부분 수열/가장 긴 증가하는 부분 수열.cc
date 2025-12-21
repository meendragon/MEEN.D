#include<iostream>
#include<vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    vector<vector<int>> dp;
    int n; cin >> n;
    dp.resize(n);
    for (int i = 0;i<n;i++) {
        dp[i].resize(n,1001);
    }
    vector<int> v;
    for (int i = 0;i<n;i++) {
        int temp;
        cin >> temp;
        v.push_back(temp);
        dp[0][i] = temp;
    }
    for (int i = 1;i<n;i++) {
        for (int j = i;j<n;j++) {
            for (int k = 0;k<j;k++) {
                if (dp[i-1][k] < dp[i-1][j]) {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }

    for (int i = n-1;i>=0;i--) {
        for (int j = 0;j<n;j++) {
            if (dp[i][j] != 1001) {
                cout << i+1;
                return 0;
            }
        }
    }


}