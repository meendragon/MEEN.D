import sys

def howFar(a,b,corp):
    if corp[a-1] < corp[b-1]:
        ans = corp[b-1] - corp[a-1]
    else:
        ans = corp[a-1] - corp[b-1]

    print(ans)

n,m = map(int,sys.stdin.readline().split())

corp = list(map(int,sys.stdin.readline().split()))

for i in range(m):
    cmd = list(map(int,sys.stdin.readline().split()))
    if(cmd[0] == 1):
        corp[cmd[1]-1] = cmd[2]
    elif(cmd[0] == 2):
        howFar(cmd[1],cmd[2],corp)




