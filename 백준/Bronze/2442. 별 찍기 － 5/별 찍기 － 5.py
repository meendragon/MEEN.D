import sys
n = int(sys.stdin.readline())
for i in range(n,0,-1):
    for k in range(i-1):
        print(' ',end = '')
    for j in range(1,2*(n-i+1)):
        print('*',end="")
    print()
