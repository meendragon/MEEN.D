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
    int n,m;
    cin >> n >> m;
    double lowPack = INT_MAX;
    int lowEach = INT_MAX;
    for(int i = 0;i<m;i++){
        int pack,each;
        cin >> pack >> each;
        double pack_each = (double)pack/6.0;
        lowPack = min(lowPack,pack_each);
        lowEach = min(lowEach,each);
    }
    if(lowEach<lowPack){
        cout << lowEach*n<< '\n';
    }else{
        int addx = min(int(lowPack*6),(n%6)*lowEach);
        cout << (lowPack*(n/6))*6 + addx << '\n';
    }
        
    return 0;
}

