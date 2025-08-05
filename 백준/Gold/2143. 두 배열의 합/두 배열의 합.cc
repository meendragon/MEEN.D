#include<iostream>
#include<vector>
#include <map>

using namespace std;
vector<int> a,b;
map<long long, int> a_hash,b_hash;
void make_container(int len, vector<int>& v, map<long long, int>& mp) {
    for (int i = 0;i<len;i++) {
        int temp;
        cin >> temp;
        v.push_back(temp);
    }
    for (int i = 0;i<len;i++) {
        long long sum = 0;
        for (int j = i;j<len;j++) {
            sum+=v[j];
            mp[sum]++;
        }
    }
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long target; cin >>target;
    int a_len,b_len;
    cin >> a_len; make_container(a_len,a,a_hash);
    cin >> b_len; make_container(b_len,b,b_hash);

    long long result = 0;
    for (auto [sum_a,cnt_a] : a_hash) {
        long long want_b = target - sum_a;
        if (b_hash.count(want_b)) {
            result += (long long)cnt_a * b_hash[want_b];
        }
    }

    cout << result << endl;

    return 0;
}