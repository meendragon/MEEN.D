import sys

n,m = map(int,sys.stdin.readline().split())

temp = n*m
if temp%3 ==0:
    print("YES")
else:
    print("NO")