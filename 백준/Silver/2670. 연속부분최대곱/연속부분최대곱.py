import sys

n = int(sys.stdin.readline())
line = [float(sys.stdin.readline()) for _ in range(n)]

ans = 0.0
current = 1.0

for i in range(n):
    current *= line[i]
    ans = max(ans, current)
    if current < 1.0:
        current = 1.0

print(f"{ans:.3f}")