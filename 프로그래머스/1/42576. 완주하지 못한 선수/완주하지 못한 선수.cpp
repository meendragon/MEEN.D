#include <string>
#include <vector>
#include<unordered_map>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string,int> cnt;
    for(auto &p : participant){
        cnt[p]++;
    }
    for(auto &c : completion){
        cnt[c]--;
    }
    for (auto &x : cnt)
    if (x.second > 0)
        return x.first;
    
    string answer = "";
    return answer;
}   