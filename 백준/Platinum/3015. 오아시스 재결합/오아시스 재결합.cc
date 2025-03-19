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

#define pp pair<int,int>

using namespace std;
int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
    int n,input;
    cin >> n;
    stack<pp> st;
    long long sum = 0;
    int max;
    for(int i = 0;i<n;i++){
        cin >> input;
        if(st.empty()) {st.push({input,1});max = input;}
        else{
            if(st.top().first==input){
                if(max==input){
                    sum+=st.top().second;
                    st.top().second++;
                }
                else{
                    st.top().second++;
                    sum+=st.top().second;
                }
            }else if(st.top().first<input){
                while(st.top().first<input){
                    sum+=st.top().second;
                    st.pop();
                    if(st.empty()) break;
                }
                if(st.empty()){max = input;st.push({input,1});}
                else if(st.top().first==input){
                    if(max==input){
                        sum+=st.top().second;
                        st.top().second++;
                    }else{
                        st.top().second++;
                        sum+=st.top().second;
                    }
                }
                else {sum++;st.push({input,1});}
                
            }else{
                sum++;
                st.push({input,1});
            }
        }
    }
    cout << sum << '\n';
    
    return 0;
}
