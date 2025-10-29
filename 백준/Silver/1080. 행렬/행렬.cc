#include<iostream>
#include<vector>


using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n,m;
    cin >> n >> m;

    vector<vector<bool>> a(n);
    vector<vector<bool>> b(n);
    for (int i = 0;i<n;i++) {
        string temp;
        cin >> temp;
        for (int j = 0;j<temp.length();j++) {
            if (temp[j] == '0') {
                a[i].push_back(false);
            }else {
                a[i].push_back(true);
            }
        }
    }  for (int i = 0;i<n;i++) {
        string temp;
        cin >> temp;
        for (int j = 0;j<temp.length();j++) {
            if (temp[j] == '0') {
                b[i].push_back(false);
            }else {
                b[i].push_back(true);
            }
        }
    }
    if (m<3 || n<3) {
        bool failToSame = false;
        for (int i = 0;i<n;i++) {
            for (int j = 0;j<m;j++) {
                if (a[i][j] != b[i][j]) {
                    failToSame = true;
                }
            }
        }
        if (failToSame){cout << -1;}
        else{cout << 0;}
        return 0;
    }
    int count = 0;
    for (int i = 0;i<n-2;i++) {
        for (int j = 0;j<m-2;j++) {
            if (a[i][j] != b[i][j]) {
                for (int k = 0;k<3;k++) {
                    for (int l = 0;l<3;l++) {
                        if (a[i+k][j+l]) {
                            a[i+k][j+l] = false;
                        }else {
                            a[i+k][j+l] = true;
                        }
                    }
                }
                count++;
            }

        }
    }
    bool failToSame = false;
    for (int i = 0;i<n;i++) {
        for (int j = 0;j<m;j++) {
            if (a[i][j] != b[i][j]) {
                failToSame = true;
            }
        }
    }
    if (failToSame){cout << -1;}
    else{cout << count;}



    return 0;
}