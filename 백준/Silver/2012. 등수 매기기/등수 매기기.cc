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

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int n;
    cin >> n;
    priority_queue<int,vector<int>,greater<int>> expected;
    for(int i = 0;i<n;i++){
        int temp;
        cin >> temp;
        expected.push(temp);
    }
    long long sum = 0;
    for(int i = 1;i<=n;i++){
        int top = expected.top();
        expected.pop();
        top = top-i;
        if(top<0){
            top*=(-1);
        }
        sum+=top;
    }
    cout << sum <<'\n';
    
    return 0;
}

