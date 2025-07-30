#include <iostream>
#include <vector>
#include <algorithm> // std::min을 위해

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, s;
    cin >> n >> s;

    vector<int> arr(n); // 편의를 위해 0-based 인덱싱 사용
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int pt1 = 0; // 왼쪽 포인터
    int pt2 = 0; // 오른쪽 포인터
    long long current_sum = 0; // 오버플로를 피하기 위해 long long 사용 (문제 제약상 int도 가능할 수 있음)
    int min_length = n + 1; // 가능한 어떤 길이보다 큰 값으로 초기화

    while (pt2 < n) { // pt2가 모든 요소를 순회하도록
        current_sum += arr[pt2]; // 윈도우를 오른쪽으로 확장
        pt2++;

        // 현재 합이 유효(>= s)하다면, 왼쪽에서 윈도우를 줄여 최소 길이를 찾으려고 시도
        while (current_sum >= s) {
            min_length = min(min_length, pt2 - pt1); // 최소 길이 업데이트
            current_sum -= arr[pt1]; // 윈도우를 왼쪽에서 축소
            pt1++;
        }
    }

    // min_length가 여전히 n + 1이라면, 그런 부분 배열이 없다는 의미
    if (min_length == n + 1) {
        cout << 0 << endl;
    } else {
        cout << min_length << endl;
    }

    return 0;
}