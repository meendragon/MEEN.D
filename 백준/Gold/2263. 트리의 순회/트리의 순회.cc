#include<iostream>
#include<vector>

using namespace std;

vector<int> inOrder,postOrder,indexx;
void input(int n) {
    inOrder.resize(n+1);
    postOrder.resize(n+1);
    indexx.resize(n+1);
    for (int i = 1;i<=n;i++) {
        cin >> inOrder[i];
        indexx[inOrder[i]] = i;
    }
    for (int i = 1;i<=n;i++) {
        cin >> postOrder[i];
    }
}
void makePreorder(int inStart, int inEnd, int postStart, int postEnd) {
    if (inStart > inEnd || postStart > postEnd) {
        return ;
    }
    int root = postOrder[postEnd];
    int rootIndex = indexx[root];
    int leftSize = rootIndex - inStart;
    cout << root << ' ';
    makePreorder(inStart, rootIndex-1,postStart,postStart+leftSize-1);
    makePreorder(rootIndex+1,inEnd,postStart+leftSize,postEnd-1);
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n; cin >> n;
    input(n);
    makePreorder(1,n,1,n);
    return 0;
}
/*
★전위 순회는 뿌리->왼쪽 자식->오른쪽 자식 순



★중위 순회는 왼쪽자식-> 뿌리-> 오른쪽 자식



★후위 순회는 왼쪽자식->오른쪽 자식-> 뿌리
 */