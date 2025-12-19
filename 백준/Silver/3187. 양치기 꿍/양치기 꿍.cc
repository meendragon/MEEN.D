#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<vector<char>> vv;
vector<vector<bool>> checked;
int totalk = 0, totalv = 0; // 초기화 습관 중요
int a, b;
int movex[4] = {0, 0, -1, 1};
int movey[4] = {-1, 1, 0, 0};

void search(int x, int y) {
    int v = 0;
    int k = 0;

    queue<pair<int, int>> q;
    q.emplace(x, y);

    // [수정 1] 시작점 방문 처리 및 카운팅 필수!
    checked[x][y] = true;
    if (vv[x][y] == 'v') v++;
    if (vv[x][y] == 'k') k++;

    while (!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();
        int curx = cur.first;
        int cury = cur.second;

        for (int i = 0; i < 4; i++) {
            int nextx = curx + movex[i];
            int nexty = cury + movey[i];

            // [수정 2] 범위 조건을 <= 로 변경 (1-based index 사용 시)
            if (nextx > 0 && nextx <= a && nexty > 0 && nexty <= b) {
                if (!checked[nextx][nexty] && vv[nextx][nexty] != '#') {
                    checked[nextx][nexty] = true; // 큐에 넣을 때 방문 처리
                    q.emplace(nextx, nexty);

                    if (vv[nextx][nexty] == 'v') {
                        v++;
                    }
                    if (vv[nextx][nexty] == 'k') {
                        k++;
                    }
                }
            }
        }
    }

    if (k > v) {
        totalk += k;
    } else {
        totalv += v;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> a >> b;

    vv.resize(a + 1);
    checked.resize(a + 1);
    for (int i = 0; i <= a; i++) { // 0번 인덱스부터 안전하게 리사이즈
        vv[i].resize(b + 1);
        checked[i].resize(b + 1, false); // false 초기화 명시 권장
    }

    for (int i = 1; i <= a; i++) {
        for (int j = 1; j <= b; j++) {
            // int temp; // 불필요한 변수 삭제
            cin >> vv[i][j];
        }
    }

    for (int i = 1; i <= a; i++) {
        for (int j = 1; j <= b; j++) {
            if (!checked[i][j] && vv[i][j] != '#') {
                search(i, j);
            }
        }
    }

    cout << totalk << ' ' << totalv;
    return 0;
}