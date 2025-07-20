import sys

n,k = map(int,sys.stdin.readline().split())
temperature = list(map(int,sys.stdin.readline().split()))
maxx = 101*(-1)*k
for i in range(0,n-k+1):
    subsum = 0
    for j in range(k):
        subsum+=temperature[i+j]
    maxx = max(maxx,subsum)

print(maxx)