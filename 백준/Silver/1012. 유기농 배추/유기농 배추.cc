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
int M,N,K;
bool arr[51][51];
int xx[4] = {-1,1,0,0};
int yy[4] = {0,0,-1,1};
void input(){
    cin >> M >> N >> K;
    for(int i = 1;i<=K;i++){
        int a,b;
        cin >> a >> b;
        arr[b+1][a+1] = 1;
    }
}
int bfs(){
    int cnt = 0;
    for(int i = 1;i<=N;i++){
        for(int j = 1;j<=M;j++){
            if(arr[i][j]==1){
                cnt++;
                queue<pp> q;
                q.push({i,j});
                while(!q.empty()){
                    int x_front = q.front().first;
                    int y_front = q.front().second;
                    q.pop();
                    for(int i = 0;i<4;i++){
                        int X = x_front+xx[i];
                        int Y = y_front+yy[i];
                        if(X>=1&&X<=N&&Y>=1&&Y<=M){
                            if(arr[X][Y]==1){
                                q.push({X,Y});
                                arr[X][Y] = 0;
                            }
                        }
                    }
                }
            }
        }
    }
    return cnt;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int T;
    cin >> T;
    for(int i = 0;i<T;i++){
        input();
        cout << bfs() << '\n';
        for(int j = 1;j<=50;j++){
            for(int k = 1;k<=50;k++){
                arr[j][k] = 0;
            }
        }
    }
    return 0;
}
    

