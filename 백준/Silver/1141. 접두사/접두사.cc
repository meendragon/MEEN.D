#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n; cin >> n;
    vector<string> v;
    for (int i = 0;i<n;i++) {
        string input;
        cin >> input;
        v.push_back(input);
    }
    int count = 0;
    sort(v.begin(),v.end());
    for (int i = 0;i<n-1;i++) {
        string temp1 = v[i];
        string temp2 = v[i+1];
        int len = temp1.length();
        if (temp1 == temp2.substr(0,len)) {
            count++;
        }

    }
    cout << n - count;




    return 0;
}