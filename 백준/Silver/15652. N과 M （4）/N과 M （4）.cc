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
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n >> m;
    for(int i = 1;i<=n;i++){
        queue<vector<int>> q;
        vector<int> v;
        v.push_back(i);
        q.push(v);
        while(!q.empty()){
            vector<int> current = q.front();
            q.pop();
            if(current.size() == m){
                for(int i = 0;i<m;i++){
                    cout << current[i];
                    if(i==m-1){
                        cout << '\n';
                    }else{
                        cout << ' ';
                    }
                }
            }else{
                int last = current.back();
                for(int next = last;next<=n;next++){
                    vector<int> nextV = current;
                    nextV.push_back(next);
                    q.push(nextV);
                }
            }
        }
    }
    return 0;
}


