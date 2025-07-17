#include<iostream>
#include<climits>
using namespace std;

#define MAX 1100
int dp[MAX+1];

int main(){
    ios::sync_with_stdio(0); cin.tie(0);

    int c,n;
    cin >> c >> n;
    dp[0] = 0;
    for (int i = 1;i<=MAX;i++) {
        dp[i] = INT_MAX;
    }
    int cost, customer;
    for (int num = 1;num<=n;num++) {
        cin >> cost >> customer;
        for (int i = customer;i<=MAX;i++) {
            if (dp[i-customer]!=INT_MAX) dp[i] = min(dp[i],dp[i-customer]+cost);
        }
    }
    int ret = INT_MAX;
    for (int i=c;i<=c+100;i++) {
        ret = min(dp[i],ret);
    }
    cout << ret;

}