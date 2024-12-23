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
#include<limits.h>
#define pp pair<char,int>
using namespace std;

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n;cin >> n;
    string cmd; cin >> cmd;
    int input;
    double temp;
    stack<double> st;
    map<char,int> mp;
    for(int i = 0;i<cmd.length();i++){
        if(cmd[i]>64&&mp.find(cmd[i])==mp.end()){cin >> input; mp.insert({cmd[i],input});}
    }
    for(int i = 0;i<cmd.length();i++){
        
        if(cmd[i]>64){
            st.push(mp[cmd[i]]);
        }else{
            temp = st.top();
            st.pop();
            switch(cmd[i]){
                case '+':
                    temp = st.top()+temp;
                    st.pop();
                    st.push(temp);
                    break;
                case '-':
                    temp = st.top()-temp;
                    st.pop();
                    st.push(temp);
                    break;
                case '/':
                    temp = st.top()/temp;
                    st.pop();
                    st.push(temp);
                    break;
                case'*':
                    temp = st.top()*temp;
                    st.pop();
                    st.push(temp);
                    break;
            }

        }
    }
    cout << fixed;
    cout.precision(2);
    cout << st.top() << '\n';
    
    return 0;
}
