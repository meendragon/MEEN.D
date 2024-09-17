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
#include<stdlib.h>
#include<limits.h>
#define tp tuple<int,int,int>
#define pp pair<int, int>
using namespace std;
string input1,input2;
int arr[1001][1001];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    getline(cin,input1);
    getline(cin,input2);
    int len1 = input1.length();
    int len2 = input2.length();
    int ans=0;
    for(int i = 0;i<len1;i++){
        for(int j = 0;j<len2;j++){
            int maxx = max(arr[i][j],arr[i+1][j]);
            maxx = max(maxx,arr[i][j+1]);
            if(input1[i]==input2[j]){
                arr[i+1][j+1] = arr[i][j]+1;
            }else{
                arr[i+1][j+1] = maxx;
            }
            ans = max(arr[i+1][j+1],ans);
        }
    }
    cout << ans << '\n';
    return 0;
}
    

