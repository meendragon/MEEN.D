#include<iostream>
#include<vector>
using namespace std;
bool nonPrimeList[100001];
vector<int> v;
void makeNonPrimeList() {
    // 0과 1 처리
    nonPrimeList[0] = true;
    nonPrimeList[1] = true;

    // 2부터 시작, i*i가 범위 넘어가기 전까지만 확인 (루트 N)
    for (int i = 2; i * i <= 100000; i++) {
        // 이미 지워진 수(소수가 아닌 수)면 패스
        if (nonPrimeList[i]) continue;

        // i가 소수라면, i의 배수들을 지움
        // 시작은 i*i 부터 (그 이전 배수는 이미 지워짐)
        // 증가는 i씩 더하기 (곱하기 아님!)
        for (int j = i * i; j <= 100000; j += i) {
            nonPrimeList[j] = true;
        }
    }
    for (int i = 0;i<=100000;i++) {
        if (!nonPrimeList[i])
            v.push_back(i);
    }
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int a,b;
    cin >> a >> b;
    makeNonPrimeList();
    int underPrime = 0;
    for (int i = a;i<=b;i++) {
        int temp = i;
        int count = 0;
        while (temp > 1) {
            for (int j = 0;j<v.size();j++) {
                if (temp == 1){break;}
                if (temp%v[j] == 0) {
                    temp /= v[j];
                    count++;
                    j--;
                }
            }
        }
        if (!nonPrimeList[count]) {
            underPrime++;
        }
    }
    cout << underPrime;

    return 0;
}