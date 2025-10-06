#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    long long n;
    cin >> n;

    vector<long long> ct(10, 0);  // 각 숫자별 카운트

    long long base = 1;  // 자릿수 단위 (1, 10, 100, ...)
    while (n > 0) {
        long long temp = n % (base * 10);  // 현재 자리 이하의 값
        long long digitPart = temp / base; // 현재 자리의 숫자
        long long higher = n / (base * 10); // 더 높은 자리
        long long lower = temp % base;      // 현재 자리 아래 부분

        // 현재 자리까지의 숫자 카운트 누적
        for (int d = 0; d < 10; d++) {
            ct[d] += higher * base;  // 상위자리 반복되는 수만큼 더함
        }

        for (int d = 0; d < digitPart; d++) {
            ct[d] += base;
        }

        ct[digitPart] += lower + 1;  // 현재 자리까지의 나머지 부분

        ct[0] -= base;  // 0은 앞자리에서 세지 않으므로 보정

        base *= 10;
        if (n < base) break;  // 더 이상 자리 없으면 종료
    }
    for (int i = 0;i<10;i++) {
        cout << ct[i] << ' ';
    }

    return 0;
}