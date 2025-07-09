import sys

n = int(sys.stdin.readline().strip())
ans = n // 5
if(n%5==0):
    print(ans)
else:
    print(ans+1)