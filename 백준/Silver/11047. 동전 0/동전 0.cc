#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int ct = 0;

int makeSmaller(int k, int div){
    int temp = k;
    while(temp>=div){
        temp-=div;
        ct++;
    }
    return temp;
};

int main(void){
    
    ios::sync_with_stdio(0);cin.tie(0);cout.tie(0);
    
    int n,k; int temp;int index;bool a = 0;
    vector<int> v;
    
    cin >> n >> k;
    index = n;
    for(int i = 0;i<n;i++){
        cin >> temp;
        v.push_back(temp);
        if(temp > k && a == 0){
            index = i;
            a=1;
        }
    }
    
    for(int i=(index-1);i>=0;i--){
        k = makeSmaller(k,v[i]);
    }
    cout << ct <<'\n';
    
    
    
    return 0;
}
