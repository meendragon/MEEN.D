#include <string>
#include <vector>
#include <queue>
using namespace std;

struct Process {
    int start;
    int cost;
    int idx;
    Process(int s, int c, int i) : start(s), cost(c), idx(i) {}
};

struct CompProcess {
    bool operator()(const Process& a, const Process& b) const {
        return a.start > b.start;
    }
};

struct CompQueue {
    bool operator()(const Process& a, const Process& b) const {
        if (a.cost == b.cost) return a.start > b.start;
        return a.cost > b.cost;
    }
};

int solution(vector<vector<int>> jobs) {
    priority_queue<Process, vector<Process>, CompProcess> pq;
    for (int i = 0; i < jobs.size(); i++)
        pq.emplace(jobs[i][0], jobs[i][1], i);

    priority_queue<Process, vector<Process>, CompQueue> ready;

    int t = 0;
    int sum = 0;
    int n = jobs.size();

    while (!pq.empty() || !ready.empty()) {

        while (!pq.empty() && pq.top().start <= t) {
            ready.push(pq.top());
            pq.pop();
        }

        if (!ready.empty()) {
            Process cur = ready.top();
            ready.pop();

            t += cur.cost;
            sum += (t - cur.start);

        } else {
            t = pq.top().start;
        }
    }

    return sum / n;
}