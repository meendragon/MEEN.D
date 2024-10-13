#include<stdio.h>
int memo[1001] = { 0 };
int box_count(int n);
int main()
{
	int n;
	int ans;
	scanf("%d", &n);
	ans = box_count(n);
	printf("%d", ans);

	return 0;
}
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