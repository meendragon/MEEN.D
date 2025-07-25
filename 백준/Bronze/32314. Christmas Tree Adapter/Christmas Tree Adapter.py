import sys

tree = int(sys.stdin.readline().strip())
w,v = map(int,sys.stdin.readline().strip().split())
adapter = w/v
if tree <= adapter:
    print(1)
else:
    print(0)