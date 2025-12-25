#include <iostream>
#include <cmath> // abs 함수

using namespace std;

int n, r1, r2, c1, c2;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    if (!(cin >> n >> r1 >> c1 >> r2 >> c2)) return 0;

    // 전체 패턴의 한 변의 길이 (주기)
    int len = 2 * n - 1;
    // 다이아몬드 중심 좌표 (패턴 박스 내에서의 상대 좌표)
    int center = n - 1;

    // 전체 맵을 만드는 것이 아니라, 출력해야 할 범위만 돕니다.
    for (int i = r1; i <= r2; i++) {
        for (int j = c1; j <= c2; j++) {
            // 현재 좌표를 패턴 박스(len x len) 내부의 좌표로 변환
            int r = i % len;
            int c = j % len;

            // 중심점(center, center)으로부터의 거리 계산 (Manhattan Distance)
            int dist = abs(center - r) + abs(center - c);

            // 거리가 n 이상이면 다이아몬드 바깥(.)
            if (dist >= n) {
                cout << '.';
            } else {
                // 다이아몬드 안쪽이면 문자를 출력
                // dist % 26으로 'a'~'z' 순환 처리
                cout << (char)('a' + (dist % 26));
            }
        }
        cout << '\n';
    }

    return 0;
}