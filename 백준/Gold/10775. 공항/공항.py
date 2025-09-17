import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])  # 경로 압축
    return parent[x]

def union(a, b):
    a = find(a)
    b = find(b)
    parent[a] = b  # a 게이트를 b와 연결

g = int(input())
p = int(input())

parent = [i for i in range(g+1)]  # 0 ~ g

count = 0
for _ in range(p):
    plane = int(input())
    root = find(plane)  # plane 이하에서 가장 큰 빈 게이트 찾기
    if root == 0:       # 0이면 더 이상 도킹 불가
        break
    union(root, root-1)  # root 게이트 사용 → root-1로 연결
    count += 1

print(count)