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
#include<limits.h>
#define tp tuple<int,int,int>
#define pp pair<int, int>
using namespace std;
int n,m;
vector<long long> paySum;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n >>m;
    paySum.resize(n+1,0);
    long long tempSum = 0;
    for(int i = 1;i<=n;i++){
        int temp;
        cin >> temp;
        tempSum+=temp;
        paySum[i] = tempSum;
    }
    long long maxPay = 0;
    for(int i = 1;i<=n-m+1;i++){
        maxPay = max(maxPay,paySum[i+m-1]-paySum[i-1]);
    }
    cout << maxPay << '\n';
    
    return 0;
}

