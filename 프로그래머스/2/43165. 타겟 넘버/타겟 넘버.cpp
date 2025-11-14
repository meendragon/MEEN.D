#include <string>
#include <vector>

using namespace std;

int dfs(vector<int> num, int len,int sum, int target){
    if(len == num.size()){
        //종료종료
        if(sum == target){
            return 1;
        }else{
            return 0;
        }
    }
    return dfs(num,len+1,sum+num[len],target) + dfs(num,len+1,sum-num[len],target);

}
int solution(vector<int> numbers, int target) {
    //만약 벡터 넘버가 5가 들어오면 2^5의 가짓수가 발생하는 이진트리라고 생각을 해보자
    int answer = dfs(numbers,0,0,target);
    return answer;
}