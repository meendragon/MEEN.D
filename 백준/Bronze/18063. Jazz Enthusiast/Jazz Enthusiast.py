import sys

n, c = map(int, sys.stdin.readline().split())

total_seconds = 0

for _ in range(n):
    m, s = map(int, sys.stdin.readline().strip().split(':'))
    total_seconds += m * 60 + s
    
total_seconds -= (n - 1) * c

# 시, 분, 초로 변환
h = total_seconds // 3600
m = (total_seconds % 3600) // 60
s = total_seconds % 60

# 포맷 맞추기
print(f"{h:02d}:{m:02d}:{s:02d}")