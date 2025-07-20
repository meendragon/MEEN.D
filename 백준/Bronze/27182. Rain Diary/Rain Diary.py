import sys

a,b = map(int,sys.stdin.readline().split())

if a > 7:
    print(a-7)
else:
    print(b+7)