#include<iostream>
#include<vector>

using namespace std;
int target;
bool arr[4000001];
void erato(int k) {
    long long temp = k;
    if (k>2000) return;
    temp = k*k;
    do {
        arr[temp] = true;
        temp+=k;
    }
    while (temp<=target);
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(nullptr);
    cin >> target;
    arr[0] = arr[1] = true;
    for (int i = 2;i<=target;i++) {
        if (!arr[i]){erato(i);}
    }
    vector<int> v;
    for (int i = 0;i<=target;i++) {
        if (!arr[i]){v.push_back(i);}
    }
    int answer_count = 0;
    long long current_sum = 0;
    int left = 0;
    int right = 0;

    while (right < v.size()) {
        current_sum += v[right];

        while (current_sum > target && left <= right) {
            current_sum -= v[left];
            left++;
        }

        if (current_sum == target) {
            answer_count++;
        }

        right++;
    }

    cout << answer_count << endl;

    return 0;
}