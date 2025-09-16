import sys, heapq
input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

start, end = map(int, input().split())

dist = [0] * (n+1)
dist[start] = sys.maxsize
pq = [(-dist[start], start)]  # 최대힙

while pq:
    cur_cap, u = heapq.heappop(pq)
    cur_cap = -cur_cap
    if u == end:
        print(cur_cap)
        break
    for v, w in graph[u]:
        new_cap = min(cur_cap, w)
        if new_cap > dist[v]:
            dist[v] = new_cap
            heapq.heappush(pq, (-new_cap, v))