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
vector<int> v;
vector<int> sumVector;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int n,m;
    cin >> n >> m;
    v.resize(n+1);
    v[0] = 0;
    for(int i = 1;i<=n;i++){
        cin >> v[i];
    }
    int subSum = 0;
    for(int i = 0;i<=n;i++){
        subSum+=v[i];
        sumVector.push_back(subSum);
    }
    int i,j;
    for(int k = 0;k<m;k++){
        cin >> i >> j;
        cout << sumVector[j] - sumVector[i-1] << '\n';
    }
    
    return 0;
}

