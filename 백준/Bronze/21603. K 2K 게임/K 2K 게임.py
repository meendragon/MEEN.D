import sys

n,k = map(int,sys.stdin.readline().split())
ans_list = []
for i in range(1,n+1):
    x = i%10
    kx = k%10
    kx2 = (2*k)%10
    if x!=kx and x!=kx2:
        ans_list.append(x)

print(len(ans_list))
print(*ans_list)