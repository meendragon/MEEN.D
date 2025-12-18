#include<iostream>
#include<vector>
#include<algorithm>
#include<cmath>
#include<climits>
using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n; cin >> n;
    vector<int> v;
    for(int i = 0;i<n;i++){
        int temp;  cin >> temp;
        v.push_back(temp);
    }
    int add,sub,mul,div;
    cin >> add >> sub >> mul >> div;
    int minn = INT_MAX;
    int maxx = INT_MIN;
    double len = pow(4,n-1);
    for(int i = 0;i<len;i++){
        int temp = v[0];
        int addc,subc,mulc,divc;
        addc = subc = mulc = divc = 0;
        for(int j = 1;j<n;j++){
            int move = n-1-j;
            switch((i >> (move*2) & 3)){
                case 0:
                    addc++;
                    temp += v[j];
                    break;
                case 1:
                    subc++;
                    temp -= v[j];
                    break;
                case 2:
                    mulc++;
                    temp *= v[j];
                    break;
                case 3:
                    divc++;
                    if (temp < 0){temp*=(-1);temp/=v[j];temp*=(-1);}
                    else{temp/=v[j];}
                    break;
            }
        }
        if (addc <= add && subc <= sub && mulc <= mul && divc <= div) {
            maxx = max(maxx,temp);
            minn = min(minn, temp);
        }
    }
    cout << maxx << '\n' << minn;
    return 0;
}