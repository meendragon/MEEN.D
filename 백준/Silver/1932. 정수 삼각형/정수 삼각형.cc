#include<iostream>
#include<vector>
#include<climits>
using namespace std;
class Node {
public:
    int data;
    Node* left;
    Node* right;

    Node(int data) {
        this->data = data;
        left = right = nullptr;
    }
    int getLeft() {
        return this->left->data;
    }
    int getRight() {
        return this->right->data;
    }
};
int main() {
    int n;
    cin >> n;
    vector<vector<int>> triangle(n,vector<int>());
   
    for (int i = 0;i<n;i++) {
        for (int j = 0;j<=i;j++) {
            int temp;
            cin >> temp;
            triangle[i].push_back(temp);
        }
    }
    for (int i = n-1;i>0;i--) {
        for (int j = 0;j<triangle[i].size()-1;j++) {
            int temp = max(triangle[i][j],triangle[i][j+1]);
            triangle[i-1][j]+=temp;
        }
    }
    cout << triangle[0][0];


    return 0;
}
/*
 0은 0,1 1은 1,2 2는 2,3 3은 3,4
 */
