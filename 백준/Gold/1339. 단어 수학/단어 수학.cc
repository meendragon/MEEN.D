#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<cmath>
#include<algorithm>
using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> n;
    auto cmp = [](string a, string b) {
        return a.length() < b.length();   // '작은 수가 먼저 나오도록' (min-heap)
    };
    // (2) 람다 타입 추론용 decltype
    priority_queue<string, vector<string>, decltype(cmp)> pq(cmp);
    vector<string> bag;
    for (int i = 0;i<n;i++) {
        string temp;
        cin >> temp;
        pq.push(temp);
        bag.push_back(temp);
    }
    map<string,int> dict;
    while (!pq.empty()) {
        string temp = pq.top();
        pq.pop();
        int exp = temp.length();
        for (int i = 0;i<exp;i++) {
            string cur = temp.substr(i,1);
            if (dict.find(cur) == dict.end()) {
                //nowhere
                dict[cur] = pow(10,exp-i-1);
            }
            else {
                dict[cur] += pow(10,exp-i-1);
            }
        }
    }
    vector<pair<string, int>> vec(dict.begin(), dict.end());
    sort(vec.begin(),vec.end(),[](auto &a, auto & b) {
        return a.second > b.second;
    });
    map<string,int> num;
    int k = 9;
    for (int i = 0;i<vec.size();i++) {
        num[vec[i].first] = k;
        k--;
    }
    
//딕트로 빼서 계싼은 그대로 두더라도 부여의 차이


    int sum = 0;
    for (int i = 0;i<n;i++) {
        string word = bag[i];
        int exp = word.length();
        for (int j = 0;j<word.length();j++) {
            sum+=num[word.substr(j,1)]*pow(10,--exp);
        }
    }
    cout << sum;

    return 0;

}