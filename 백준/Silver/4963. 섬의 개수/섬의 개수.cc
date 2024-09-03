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
int w,h;
int ans;
int xx[8] = {-1,1,0,0,-1,1,-1,1};
int yy[8] = {0,0,-1,1,-1,-1,1,1};
vector<vector<bool>> v;
void input(){
    v.resize(h+1);
    for(int i = 1;i<=h;i++){
        v[i].resize(w+1);
    }
    bool temp;
    for(int i = 1;i<=h;i++){
        for(int j = 1;j<=w;j++){
            cin >> temp;
            v[i][j] = temp;
        }
    }
}
void bfs(){
    ans = 0;
    for(int i = 1;i<=h;i++){
        for(int j = 1;j<=w;j++){
            if(v[i][j] == 1){
                ans++;
                v[i][j] = 0;
                queue<pp> q;
                q.push({i,j});
                while(!q.empty()){
                    int front_x = q.front().first;
                    int front_y = q.front().second;
                    q.pop();
                    for(int k = 0;k<8;k++){
                        int X = front_x + xx[k];
                        int Y = front_y + yy[k];
                        if(X>=1 && Y>=1 && X<=h && Y<=w){
                            if(v[X][Y] == 1){
                                v[X][Y] = 0;
                                q.push({X,Y});
                            }
                        }
                    }
                }
            }
        }
    }
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    while(1){
        cin >> w >> h;
        if(w == 0 && h == 0) break;
        input();
        bfs();
        cout << ans << '\n';
    }
    
    return 0;
}
    

