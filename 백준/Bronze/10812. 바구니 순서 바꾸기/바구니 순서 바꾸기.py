import sys
from collections import deque

n,m = map(int, sys.stdin.readline().split())
basket = []
for p in range(n):
    basket.append(p+1)

for p in range(m):
    i,j,k = map(int, sys.stdin.readline().split())
    subList = deque(basket[i - 1:j])
    for x in range(k-i):
        subList.append(subList.popleft())

    basket[i - 1:j] = subList



print(*basket)
