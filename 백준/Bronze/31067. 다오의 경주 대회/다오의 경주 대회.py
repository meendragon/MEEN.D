import sys
n,k = map(int,input().split())
track = sys.stdin.readline().split()

ex = -1
rise = True
count = 0
for i in track:
    temp = int(i)
    if ex >= temp:
        temp+=k
        count+=1
    if ex < temp:
        ex = temp
    else:
        rise = False
        print("-1")
if rise:
    print(count)