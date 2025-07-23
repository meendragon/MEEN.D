#include <iostream>
#include <string>
#include <vector>
#include <algorithm> // for std::min, std::reverse
#include <limits>    // for std::numeric_limits<int>::max()

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string str;
    cin >> str;
    size_t n = str.length();

    // 1. 팰린드롬 여부를 저장할 DP 테이블 (O(N^2) 시간)
    // dp[i][j]는 str[i...j]가 팰린드롬인지 여부
    vector<vector<bool>> is_palindrome(n, vector<bool>(n, false));

    // 길이 1
    for (int i = 0; i < n; ++i) {
        is_palindrome[i][i] = true;
    }

    // 길이 2
    for (int i = 0; i < n - 1; ++i) {
        if (str[i] == str[i+1]) {
            is_palindrome[i][i+1] = true;
        }
    }

    // 길이 3 이상
    for (int len = 3; len <= n; ++len) {
        for (int i = 0; i <= n - len; ++i) {
            int j = i + len - 1;
            if (str[i] == str[j] && is_palindrome[i+1][j-1]) {
                is_palindrome[i][j] = true;
            }
        }
    }

    // 2. 최소 팰린드롬 분할 개수를 저장할 DP 테이블 (O(N^2) 시간)
    // min_cuts[i]는 str의 처음부터 i-1번째 문자까지의 최소 분할 개수 (길이 i인 접두사)
    // 따라서 min_cuts 배열의 크기는 n+1
    vector<int> min_cuts(n + 1, numeric_limits<int>::max());
    min_cuts[0] = 0; // 빈 문자열은 0개의 분할

    for (int i = 1; i <= n; ++i) { // str[0...i-1]까지의 최소 분할 개수를 찾음
        // str[0...i-1]을 'str[0...j-1]'와 'str[j...i-1]'로 분할한다고 가정
        // 이때 str[j...i-1]이 팰린드롬이어야 함
        for (int j = 0; j < i; ++j) {
            // is_palindrome 배열은 0-indexed이므로, str[j]부터 str[i-1]까지 확인
            if (is_palindrome[j][i-1]) {
                // min_cuts[j]는 str[0...j-1]까지의 최소 분할 개수
                // 거기에 현재 팰린드롬 str[j...i-1] 1개를 더함
                min_cuts[i] = min(min_cuts[i], min_cuts[j] + 1);
            }
        }
    }

    // 최종 결과는 str 전체 (str[0...n-1])에 대한 최소 분할 개수
    cout << min_cuts[n] << endl;

    return 0;
}