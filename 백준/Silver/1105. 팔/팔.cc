#include<iostream>

using namespace std;
long long l,r;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> l >> r;
    string left = to_string(l);
    string right = to_string(r);
    int count=0;
    while (left.length() < right.length()) {
        left = "0" + left;
    }

    for (int i = 0; i < left.length(); i++) {
        if (left[i] == right[i]) {
            if (left[i] == '8') count++;
        } else {
            break;
        }
    }
    cout << count;
    return 0;
}