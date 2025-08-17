import sys
import heapq

n = int(sys.stdin.readline())
party_size = 0
priority_queue =[]
for _ in range(n):
    num = int(sys.stdin.readline())
    heapq.heappush(priority_queue,num)

need = 0
people = 0
while len(priority_queue) > 0:
    num = heapq.heappop(priority_queue)
    need = num + 1
    people += 1
    party_size = max(party_size, need)
    if party_size == people:
        print(party_size)
        break

