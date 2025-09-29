#include<iostream>
#include<vector>
#include<cmath>
#include<iomanip>
using namespace std;
vector<bool> idx;
double combination(int n, int r) {
    double temp = 1;
    for (int i = 1;i<=r;i++) {
        temp = temp*(n-i+1)/i;
    }
    return temp;
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int a_percent,b_percent;
    cin >> a_percent >> b_percent;
    double a_ratio = double(a_percent) / 100.0;
    double b_ratio = double(b_percent) / 100.0;
    //가능한 득점의 수는 0점 ~ 18점
    //2,3,5,7,11,13,17 이 둘다 아닌걸 전체 확률에서 빼면됨
    idx.resize(16,false);
    for (int p : {2,3,5,7,11,13,17}) idx[p] = true;

    //디피테이블 초기 값은 구함 ㅇㅇ 그럼 그 다음은 이제 사실상 누적이라
    //3골이 들어간 경우로 하고싶으면 2골 케이스에다가 그냥 comibnation(16,1)로 하고

    double ans = 0.0;
    double a_sum,b_sum;
    a_sum = b_sum = 0.0;
    for (int k = 0; k <= 18; k++) {
        double a_temp = combination(18, k) * pow(a_ratio, k) * pow(1-a_ratio, 18-k);
        double b_temp = combination(18, k) * pow(b_ratio, k) * pow(1-b_ratio, 18-k);
        if (idx[k]) {a_sum += a_temp;b_sum+=b_temp;}
    }
    ans = a_sum + b_sum - (a_sum*b_sum);
    cout << fixed << setprecision(16) << ans << '\n';
    return 0;
}