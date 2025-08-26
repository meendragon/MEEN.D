import sys

input = sys.stdin.readline

R, C = map(int, input().split())
N = int(input())

# 각 유물 a의 [minR, minC, maxR, maxC]; 없으면 None
box = [None] * (N + 1)

for _ in range(N):
    a, v, h = map(int, input().split())  # v=row, h=col
    if box[a] is None:
        box[a] = [v, h, v, h]
    else:
        box[a][0] = min(box[a][0], v)
        box[a][1] = min(box[a][1], h)
        box[a][2] = max(box[a][2], v)
        box[a][3] = max(box[a][3], h)

best_id = -1
best_area = -1

for i in range(1, N + 1):
    if box[i] is None:
        continue
    minR, minC, maxR, maxC = box[i]
    area = (maxR - minR + 1) * (maxC - minC + 1)
    if area > best_area or (area == best_area and i < best_id):
        best_area = area
        best_id = i

print(best_id, best_area)