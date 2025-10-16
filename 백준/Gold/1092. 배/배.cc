#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n;
    vector<int> crane(n);
    for (int i = 0; i < n; i++) cin >> crane[i];
    cin >> m;
    vector<int> box(m);
    for (int i = 0; i < m; i++) cin >> box[i];

    sort(crane.rbegin(), crane.rend());
    sort(box.rbegin(), box.rend());

    if (box[0] > crane[0]) {
        cout << -1;
        return 0;
    }

    vector<int> pos(n, 0);   // 각 크레인이 현재 탐색 중인 박스 위치
    vector<bool> moved(m, false);
    int moved_count = 0;
    int time_count = 0;

    while (moved_count < m) {
        for (int i = 0; i < n; i++) {
            while (pos[i] < m) {
                if (!moved[pos[i]] && crane[i] >= box[pos[i]]) {
                    moved[pos[i]] = true;
                    moved_count++;
                    pos[i]++;
                    break;
                }
                pos[i]++;
            }
        }
        time_count++;
    }

    cout << time_count;
    return 0;
}