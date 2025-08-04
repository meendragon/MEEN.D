import sys

n,l,k = map(int,sys.stdin.readline().split())
both = 0
only = 0
for i in range(n):
    a,b = map(int,sys.stdin.readline().split())
    if a <= l:
        if b <=l:
            both += 1
        else:
            only += 1

ans = 0
if both <= k:
    ans += both*140
    if k-both <= only:
        ans += (k-both)*100
    else:
        ans += only*100
else:
    ans += k*140

print(ans)