import sys

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    pa, pb = find(a), find(b)
    if pa == pb:
        return True
    if size[pa] < size[pb]:
        pa, pb = pb, pa  # 항상 큰 쪽이 부모
    parent[pb] = pa
    size[pa] += size[pb]
    return False

n,m = map(int,sys.stdin.readline().split())

parent = [i for i in range(n)]
size = [1 for i in range(n)]
no_cycle = True
for idx in range(m):
    a,b = map(int,sys.stdin.readline().split())
    if union(a, b):
        print(idx+1)
        no_cycle = False
        break

if no_cycle:
    print(0)
