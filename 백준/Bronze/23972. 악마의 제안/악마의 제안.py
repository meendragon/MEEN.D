import sys

k,n = map(int, input().split())

if (n-1) == 0:
    print(-1)
else:
    temp = n * k // (n - 1)
    if (n*k) % (n-1) != 0:
        temp+=1


    if temp > 1:
        print(temp)
    else:
        print(-1)
    # nx - nk >= x
    # (n-1)x >= nk
    #