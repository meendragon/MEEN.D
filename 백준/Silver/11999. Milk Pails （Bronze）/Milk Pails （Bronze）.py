import sys

x,y,m = map(int,sys.stdin.readline().split())

maxx = m//x
maxy = m//y

ans = 0
for i in range(maxx+1):
    for j in range(maxy+1):
        temp = i*x + j*y
        if temp <= m:
            ans = max(ans, temp)

print(ans)