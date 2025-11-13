#include <string>
#include <vector>
#include<queue>
#include<algorithm>
#include<unordered_map>
using namespace std;
struct Node{
    int idx; int play;
};
struct Comp{
    bool operator()(const Node &a, const Node &b) const{
        if(a.play == b.play) return a.idx > b.idx;
        return a.play < b.play;
    }
};
vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    unordered_map<string,int> genreSum;
    unordered_map<string,priority_queue<Node,vector<Node>,Comp>> songInfo;
    for(int i = 0;i<genres.size();i++){
        string curGenre = genres[i];
        int curPlay = plays[i];
        genreSum[curGenre]+=curPlay;
        songInfo[curGenre].push({i,curPlay});
    }
    vector<pair<string,int>> v(genreSum.begin(),genreSum.end());
    sort(v.begin(),v.end(),[](auto &a, auto &b){
        return a.second > b.second;
    });
    for(auto& cur : v){
        string curKey = cur.first;
        int cnt = 0;
        while(!songInfo[curKey].empty() && cnt < 2){
            cnt++;
            answer.push_back(songInfo[curKey].top().idx);
            songInfo[curKey].pop();
        }
    }
    
    
    return answer;
}