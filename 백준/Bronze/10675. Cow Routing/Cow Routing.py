import sys

a,b,n = map(int,sys.stdin.readline().split())
ans = 1001
for _ in range(n):
    cost, city_count = map(int,sys.stdin.readline().split())
    cities = list(map(int,sys.stdin.readline().split()))
    has_a = False
    for j in range(len(cities)):
        if cities[j] == b and has_a:
            ans = min(ans, cost)
            break
        if cities[j] == a:
            has_a = True


if ans == 1001:
    print(-1)
else:
    print(ans)
