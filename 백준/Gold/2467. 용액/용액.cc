#include<iostream>
#include<vector>
#include<utility>
#include<climits>
using namespace std;

int main(){

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n; cin >> n;
    vector<long long> drugs;
    drugs.resize(n);
    for(int i = 0;i<n;i++){
        cin >> drugs[i];
    }
    int a,b;
    a = 0;
    b = n-1;
    pair<int,int> ans(0,n-1);
    long long opt = LONG_LONG_MAX;
    long long temp = drugs[a] + drugs[b];
    while(temp != 0 && a!=b){
        if (abs(opt) > abs(temp)) {
            opt = temp;
            ans.first = a;
            ans.second = b;
        }
        if (temp > 0) {
            b--;
            temp = drugs[a]+drugs[b];
        }else {
            a++;
            temp = drugs[a]+drugs[b];
        }
    }
    if (temp == 0) {
        ans.first = a;
        ans.second = b;
    }

    cout << drugs[ans.first] << ' ' << drugs[ans.second];


    return 0;

}