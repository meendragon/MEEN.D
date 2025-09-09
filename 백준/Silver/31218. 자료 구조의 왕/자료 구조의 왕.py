import sys

n,m,q = map(int,sys.stdin.readline().split())

green =[[0 for _ in range(m)] for _ in range(n)]

grassCount = n*m
for _ in range(q):
    query = list(map(int,sys.stdin.readline().split()))
    cmd = query[0]
    if cmd == 1:
        dy, dx, y, x = query[1:]
        while green[y-1][x-1] == 0:
            green[y-1][x-1] = 1
            grassCount -=1
            y += dy
            x += dx
            if y > n or x > m or x < 1 or y < 1:
                break
    elif cmd == 2:
        y, x = query[1], query[2]
        print(green[y-1][x-1])
    elif cmd == 3:
        print(grassCount)
    else:
        break

