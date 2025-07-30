import sys

while(True):
    line = sys.stdin.readline()
    if not line:
        break
    a,b = map(int,line.split())
    print(b//(a+1))
