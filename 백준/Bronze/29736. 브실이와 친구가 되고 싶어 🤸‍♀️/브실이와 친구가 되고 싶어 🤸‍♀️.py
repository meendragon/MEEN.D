import sys
a,b = map(int,sys.stdin.readline().split())
k,x = map(int,sys.stdin.readline().split())

start = end = 0
if k-x >= a:
    start = k-x
else:
    start = a

if k+x <=b:
    end = k+x
else:
    end = b

if end <start:
    print("IMPOSSIBLE")
else:
    print(end-start+1)