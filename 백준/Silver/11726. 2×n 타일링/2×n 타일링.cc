#include<iostream>
#include<vector>
#include<stack>
#include<queue>
#include<string>
#include<utility>
#include<map>
#include<algorithm>
#include<cmath>
#include<bitset>
#include<set>
#include<stdlib.h>
#include<time.h>
#include<limits.h>
#include<cstdlib>
#define tp tuple<int,int,int>
#define pp pair<int, int>
using namespace std;
int memo[1001] = { 0 };
int box_count(int n)
{
	if (n == 0)
		return 0;
	else if (n == 1)
		return 1;
	else if (n == 2)
		return 2;
	else if (memo[n] != 0)
		return memo[n];
	else
	{
		memo[n] = ((box_count(n - 2) + box_count(n - 1))%10007);
		return memo[n];
	}
}
int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);cout.tie(0);
	int n;
	int ans;
	cin >> n;
	ans = box_count(n);
	cout << ans << '\n';

	return 0;
}
