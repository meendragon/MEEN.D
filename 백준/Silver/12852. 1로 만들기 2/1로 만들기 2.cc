#include<iostream>
#include<vector>
#include<climits>
using namespace std;

void run(int n);
int main() {
    int n;
    cin >> n;
    vector<int> dp;
    vector<int> route;
    dp.push_back(1);
    dp.push_back(1);
    for (int i = 2;i<=n;i++) {
        dp.push_back(INT_MAX);
        if (i%2!=0 && i%3 !=0) {
            dp[i] = dp[i-1]+1;
        }else if (i%2==0&&i%3!=0) {
            dp[i] = min(dp[i-1]+1, dp[i/2]+1);
        }else if (i%2!=0&&i%3==0) {
            dp[i] = min(dp[i-1]+1, dp[i/3]+1);
        }else {
            dp[i] = min(dp[i-1]+1, dp[i/2]+1);
            dp[i] = min(dp[i],dp[i/3]+1);
        }
    }
    cout << dp[n] - 1 << endl;
    cout << n << ' ';
    while (n!=1) {
        if (n%2!=0 && n%3 !=0) {
            n--;
            route.push_back(n);
        }else if (n%2==0&&n%3!=0) {
            if (dp[n-1]+1 == dp[n]) {
                n--;
                route.push_back(n);
            }else {
                n/=2;
                route.push_back(n);
            }
        }else if (n%2!=0&&n%3==0) {
            if (dp[n-1]+1 == dp[n]) {
                n--;
                route.push_back(n);
            }else {
                n/=3;
                route.push_back(n);
            }
        }else {
            if (dp[n-1]+1 == dp[n]) {
                n--;
                route.push_back(n);
            }else if (dp[n/2]+1 == dp[n]){
                n/=2;
                route.push_back(n);
            }else {
                n/=3;
                route.push_back(n);
            }
        }
    }
    for (int x : route) {
        cout << x << ' ';
    }
    return 0;
}

/*
 3번연산자는 어디든 먼저 1차 적용 가능
 1,2번연산자는 특정 조건에 따라 적용 가능

 */
