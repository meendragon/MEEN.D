#include <bits/stdc++.h>

using namespace std;
int t, n, m;
int broken_masks[11];
int dp[11][1<<10];    // dp[row][mask]
vector<int> validMasks;
bool is_valid_current(int mask, int row);
void max_student() {
    // m 최대 10 → 가능한 mask 미리 계산
    validMasks.clear();
    for (int mask = 0; mask < (1 << m); mask++) {
        if ( (mask & (mask >> 1)) == 0 ) {//좌우 안겹치는 놈들의 경우만 마스크에 넣기로
            validMasks.push_back(mask);
        }
    }

    // dp 초기화
    for (int i = 0; i < n; i++) {
        for (int mask : validMasks) {
            dp[i][mask] = -1e9;
        }
    }

    // 첫 행
    for (int mask : validMasks) {
        if (is_valid_current(mask, 0)) {
            dp[0][mask] = __builtin_popcount(mask);
        }
    }

    // 이후 행들
    for (int row = 1; row < n; row++) {
        for (int mask : validMasks) {
            if (!is_valid_current(mask, row)) continue;
            int cnt = __builtin_popcount(mask);
            for (int prev : validMasks) {
                if (dp[row-1][prev] < 0) continue;
                // 대각선 충돌 체크
                if ( (mask << 1) & prev ) continue;
                if ( (mask >> 1) & prev ) continue;
                dp[row][mask] = max(dp[row][mask], dp[row-1][prev] + cnt);
            }
        }
    }

    // 정답
    int ans = 0;
    for (int mask : validMasks) {
        ans = max(ans, dp[n-1][mask]);
    }
    cout << ans << "\n";

}
bool is_valid_current(int mask, int row) {
    // 1. 양옆에 학생이 연속으로 앉았는지 확인
    if (mask & (mask >> 1)) {
        return false;
    }
    // 2. 부서진 자리에 앉았는지 확인
    if (mask & broken_masks[row]) {
        return false;
    }
    return true;
}

void input() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> t; //테스트 케이스
    //‘.’(앉을 수 있는 자리) 또는 ‘x’(앉을 수 없는 자리, 소문자)로 구성된다.

    for (int i = 0;i<t;i++) {
        cin >> n >> m;
        for (int j = 0; j < n; j++) broken_masks[j] = 0;
        for (int j = 0;j<n;j++) {
            string temp;
            cin >> temp;
            for (int k = 0;k<m;k++) {
                if (temp[k] == 'x'){broken_masks[j]|=(1<<k);}
            }
        }
        max_student();
    }

}
int main() {
    input();

    return 0;
}
