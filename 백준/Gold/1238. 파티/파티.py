import sys, heapq
n,m,x = map(int,sys.stdin.readline().split())

board=[[] for _ in range(n+1)]

for _ in range(m):
    a,b,c = map(int,sys.stdin.readline().split())
    board[a].append([b,c])

maxLen = -1
for i in range(n):
    maxgoLen = -1
    maxbackLen = -1
    node = [sys.maxsize for i in range(n + 1)]
    start = i+1
    node[start] = 0
    pq = [(0, start)]
    while pq:
        cur_dist, cur = heapq.heappop(pq)
        if cur_dist > node[cur]:
            continue
        for next,cost in board[cur]:
            if node[cur] + cost < node[next]:
                node[next] = min(node[next], node[cur] + cost)
                heapq.heappush(pq, (node[next], next))

    maxgoLen = max(maxgoLen, node[x])

    node = [sys.maxsize for i in range(n + 1)]
    start = x
    node[start] = 0
    pq = [(0, start)]
    while pq:
        cur_dist, cur = heapq.heappop(pq)
        if cur_dist > node[cur]:
            continue
        for next,cost in board[cur]:
            if node[cur] + cost < node[next]:
                node[next] = min(node[next], node[cur] + cost)
                heapq.heappush(pq, (node[next], next))
    maxbackLen = max(maxbackLen, node[i+1])

    maxLen = max(maxLen,maxgoLen+maxbackLen)


print(maxLen)


