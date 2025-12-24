#include <iostream>
#include <string>
#include <algorithm> 
using namespace std;

string s1, s2;

int solve(string fixed, string moving) {
    int min_len = fixed.length() + moving.length(); 
    for (int i = 0; i < fixed.length(); i++) {
        bool possible = true;
        
        for (int j = 0; j < moving.length(); j++) {
            if (i + j < fixed.length()) {
                if (fixed[i + j] == '2' && moving[j] == '2') {
                    possible = false;
                    break;
                }
            }
        }

        if (possible) {
            int current_len = max((int)fixed.length(), i + (int)moving.length());
            min_len = min(min_len, current_len);
        }
    }
    return min_len;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> s1 >> s2;
    int ans1 = solve(s1, s2);
    int ans2 = solve(s2, s1);
    cout << min(ans1, ans2);

    return 0;
}