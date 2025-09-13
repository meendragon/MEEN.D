import sys



def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    pa, pb = find(a), find(b)
    if pa != pb: #루트가 다르다면
        # pb를 pa에 붙이기
        parent[pb] = pa
        size[pa] += size[pb]
    return size[find(a)]


t = int(input())
for _ in range(t):
    f = int(input())
    parent = {}
    size = {}
    for _ in range(f):
        a, b = input().split()
        if a not in parent:
            parent[a] = a
            size[a] = 1
        if b not in parent:
            parent[b] = b
            size[b] = 1
            
        print(union(a, b))