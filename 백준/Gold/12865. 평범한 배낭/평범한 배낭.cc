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
int n,maxx;
vector<vector<int>> board;
vector<pp> ob;
void input(){
    cin >> n >> maxx;
    board.resize(n+1);
    for(int i = 1;i<=n;i++){
        board[i].resize(maxx+1);
    }
    for(int i =1;i<=n;i++){
        int w,p;
        cin >> w >> p;
        ob.push_back({w,p});
    }
}
int find(){
    for(int i = 1;i<=n;i++){
        for(int j = 1;j<=maxx;j++){
            int weight = ob[i-1].first;
            int price = ob[i-1].second;
            if(i-1<=0){
                if(weight<=j){
                    board[i][j] = price;
                }else{
                    board[i][j] = 0;
                }
            }else{
                if(j-weight>=0){
                    int now = board[i-1][j] > board[i-1][j-weight]+price ? board[i-1][j] : board[i-1][j-weight]+price;
                    board[i][j] = now;
                }else{
                    board[i][j] = board[i-1][j];
                }
            }
        }
    }
    return board[n][maxx];
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    input();
    cout << find() << '\n';
    
    return 0;
}
    

