#include<iostream>
#include<vector>
#include<utility>
using namespace std;
class Line {
public:
    pair<int,int> p1,p2;
    Line(int x1, int y1, int x2, int y2) {
        p1 = make_pair(x1,y1);
        p2 = make_pair(x2,y2);
    }
};
long long ccw(pair<int,int> p1, pair<int,int> p2, pair<int,int> p3) {
    long long val = (p2.first - p1.first)*(p3.second-p1.second) - (p2.second-p1.second)*(p3.first-p1.first);
    if (val==0) return 0;
    return (val>0) ? 1 : -1;
}
bool onSegment_internal(pair<int,int> p, pair<int,int> q, pair<int,int> r) {
    // q의 x 좌표가 p와 r의 x 좌표 범위 내에 있는지 확인
    // q의 y 좌표가 p와 r의 y 좌표 범위 내에 있는지 확인
    return (q.first >= min(p.first, r.first) && q.first <= max(p.first, r.first) &&
            q.second >= min(p.second, r.second) && q.second <= max(p.second, r.second));
}
bool onTheLine(Line l1, Line l2) {
    return onSegment_internal(l1.p1, l2.p1, l1.p2) || // l2.p1이 l1 위에 있나?
               onSegment_internal(l1.p1, l2.p2, l1.p2) || // l2.p2가 l1 위에 있나?
               onSegment_internal(l2.p1, l1.p1, l2.p2) || // l1.p1이 l2 위에 있나?
               onSegment_internal(l2.p1, l1.p2, l2.p2);   // l1.p2가 l2 위에 있나?
}
bool cross(Line l1, Line l2) {
    long long ccw1 = ccw(l1.p1, l1.p2, l2.p1);
    long long ccw2 = ccw(l1.p1, l1.p2, l2.p2);
    long long ccw3 = ccw(l2.p1, l2.p2, l1.p1);
    long long ccw4 = ccw(l2.p1, l2.p2, l1.p2);

    if (ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0) {
        // 네 점이 모두 일직선 위에 있는 경우
        if (ccw1 == 0 && ccw2 == 0 && ccw3 == 0 && ccw4 == 0) {
            return onTheLine(l1, l2);
        }
        return true;
    }
    return false;
}
vector<int> parent, group_size;
int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]); // 경로 압축
}
void unionSet(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) return;
    parent[b] = a;
    group_size[a] += group_size[b];
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    vector<Line> lines;
    int n;cin >> n;
    parent.resize(n+1);
    group_size.resize(n+1,1);
    for (int i = 0;i<n;i++) {
        int x1, x2,y1,y2;
        cin >> x1 >> y1 >> x2 >> y2;
        lines.emplace_back(x1,y1,x2,y2);
        parent[i] = i;
    }
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (cross(lines[i], lines[j])) {
                unionSet(i, j);
            }
        }
    }
    int group_count = 0;
    int max_group_size = 0;
    for (int i = 0; i < n; i++) {
        if (parent[i] == i) group_count++;
        max_group_size = max(max_group_size, group_size[find(i)]);
    }

    cout << group_count << '\n' << max_group_size << '\n';
    return 0;

}