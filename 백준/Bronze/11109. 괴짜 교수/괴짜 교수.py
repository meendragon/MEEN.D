import sys

t = int(sys.stdin.readline())
for _ in range(t):
    d,n,s,p = map(int, sys.stdin.readline().split())
    if n*p + d < n*s:
        print("parallelize")
    elif n*p + d > n*s:
        print("do not parallelize")
    else:
        print("does not matter")