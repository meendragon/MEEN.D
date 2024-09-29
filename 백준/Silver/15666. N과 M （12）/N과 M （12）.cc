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
#include<time.h>
#include<limits.h>
#define tp tuple<int,int,int>
#define pp pair<int, int>
using namespace std;
int N,M;
set<int> st;
vector<int> v;
deque<int> ct;
void f(int num){
    ct.push_back(num);
    if(ct.size()==M){
        for(int i = 0;i<M;i++){
            cout << ct.front() << ' ';
            ct.push_back(ct.front());
            ct.pop_front();
        }
        cout << endl;
    }
    else{
        int back = ct.back();
        for(int i = 0;i<v.size();i++){
            if(v[i]>=back){
                f(v[i]);
                ct.pop_back();
            }
        }
    }
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> N >> M;
   
    for(int i = 0;i<N;i++){
        int input;
        cin >> input;
        st.insert(input);
    }
    v.resize(st.size());
    
    copy(st.begin(), st.end(), v.begin());
    
    for(int i = 0;i<v.size();i++){
        f(v[i]);
        ct.clear();
    }
    return 0;
}
    

