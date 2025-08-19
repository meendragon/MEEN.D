import sys

N = int(sys.stdin.readline())


bales =[]
for _ in range(N):
    bales.append(list(map(int, sys.stdin.readline().split())))

bales.sort(key=lambda x: (x[0], x[1]),reverse=True)
dp = [1 for _ in range(N)]
for i in range(N):
    for j in range(i):
        if bales[j][0] > bales[i][0] and bales[j][1] > bales[i][1]:
            dp[i] = max(dp[i], dp[j] + 1)

answer = max(dp)
print(answer)