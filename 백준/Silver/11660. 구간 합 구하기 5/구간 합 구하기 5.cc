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
vector<vector<int>> rowSum;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int n,m;
    cin >> n >> m;
    rowSum.resize(n+1);
    for(int i = 0;i<=n;i++){
        rowSum[i].resize(n+1,0);
    }
    for(int i = 1;i<=n;i++){
        int temp;
        int tempSum = 0;
        for(int j = 1;j<=n;j++){
            cin >> temp;
            tempSum+=temp;
            rowSum[i][j] = tempSum;
        }
    }
    pp start,end;
    for(int i = 0;i<m;i++){
        cin >> start.first >> start.second >> end.first >> end.second;
        int ans = 0;
        for(int j = start.first;j<=end.first;j++){
            ans+=(rowSum[j][end.second] - rowSum[j][start.second-1]);
        }
        cout << ans << '\n';
    }
    
        
    return 0;
}

