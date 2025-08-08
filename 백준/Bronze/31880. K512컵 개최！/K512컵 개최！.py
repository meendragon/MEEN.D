import sys

n,m = map(int, sys.stdin.readline().split())

n_line = sys.stdin.readline().split()
m_line = sys.stdin.readline().split()

base = 0
for i in range(n):
    base += int(n_line[i])

for j in range(m):
    temp = int(m_line[j])
    if temp != 0:
        base *= temp

print(base)
