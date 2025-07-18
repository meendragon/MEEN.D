#include<iostream>
#include<climits>
#include<algorithm>
using namespace std;
#define DIV 1000000000;
int dp[10][101][1024];
int n;
int search(int num, int len, int bits){
    if (dp[num][len][bits] != 0) return dp[num][len][bits];
    if (len == n) {
        if (bits == 1023) return 1;
        else return 0;
    }
    int tmp = 0;
    if (num<9) {
        int next = num+1;
        tmp+=search(next,len+1,bits|1<< next);
    }
    if (num>0) {
        int next = num-1;
        tmp+=search(next,len+1,bits|1<< next);
    }
    tmp%=DIV;
    return dp[num][len][bits]=tmp;
}

int main(){
    ios::sync_with_stdio(0); cin.tie(0);
  cin >> n;
    int ans = 0;
    for (int i = 1;i<=9;i++) {
        ans+=search(i, 1, 1<<i);
        ans%=DIV;
    }
    cout << ans;
}