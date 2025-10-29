#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<vector<bool>> a(n, vector<bool>(m));
    vector<vector<bool>> b(n, vector<bool>(m));

    for (int i = 0; i < n; i++) {
        string temp;
        cin >> temp;
        for (int j = 0; j < m; j++) {
            a[i][j] = (temp[j] == '1');
        }
    }

    for (int i = 0; i < n; i++) {
        string temp;
        cin >> temp;
        for (int j = 0; j < m; j++) {
            b[i][j] = (temp[j] == '1');
        }
    }

    if (n < 3 || m < 3) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    cout << -1;
                    return 0;
                }
            }
        }
        cout << 0;
        return 0;
    }

    int cnt = 0;
    for (int i = 0; i < n - 2; i++) {
        for (int j = 0; j < m - 2; j++) {
            if (a[i][j] != b[i][j]) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        a[i + x][j + y].flip();
                    }
                }
                cnt++;
            }
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (a[i][j] != b[i][j]) {
                cout << -1;
                return 0;
            }
        }
    }

    cout << cnt;
    return 0;
}