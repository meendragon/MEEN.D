#include<iostream>
#include<utility>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;

int main() {
    int n,k;
    cin >> n >> k;
    vector<pair<int,int>> jewel;
    vector<int> bagSize;
    for (int i = 0;i<n;i++) {
        int a,b;
        cin >> a >> b;
        jewel.push_back(make_pair(a,b));
    }
    sort(jewel.begin(), jewel.end(), [](const pair<int, int>& p1, const pair<int, int>& p2) {
      if (p1.first != p2.first) {
          return p1.first < p2.first;
      }
      return p1.second > p2.second;
    });
    for (int i = 0;i<k;i++) {
        int temp;
        cin >> temp;
        bagSize.push_back(temp);
    }
    sort(bagSize.begin(),bagSize.end());
    long long subSum = 0;
    int j = 0;
    priority_queue<int> pq;
    for (int i = 0;i<bagSize.size();i++) {
        while (bagSize[i] >= jewel[j].first && j<jewel.size()) {
            pq.push(jewel[j].second);
            j++;
        }
        if (!pq.empty()) {
            subSum+=pq.top();
            pq.pop();
        }
    }
    cout << subSum;


    return 0;

}