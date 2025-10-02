import sys
import math

# 입력 처리
try:
    h_lo, h_hi = map(int, sys.stdin.readline().split())
    s_lo, s_hi = map(int, sys.stdin.readline().split())
    v_lo, v_hi = map(int, sys.stdin.readline().split())
    R, G, B = map(int, sys.stdin.readline().split())
except Exception:
    # EOF 등의 예외 처리 (BOJ 환경에서는 일반적으로 불필요)
    sys.exit()

# RGB to HSV 변환
# M, m 계산
M = max(R, G, B)
m = min(R, G, B)

# V 계산
V = M

# S 계산
if V == 0:
    S = 0
else:
    S = (255 * (V - m)) / V

# H 계산
delta = V - m
H = 0.0

if delta == 0:
    H = 0.0 # R, G, B가 모두 같으면 H는 정의되지 않지만, 문제 조건에서 R, G, B는 서로 다르다고 했으므로 이 경우는 delta > 0.
            # 다만, V-m=0 일 때 S=0 이므로 H의 값은 중요하지 않다.
            # 문제 조건: R, G, B는 서로 다르다. -> delta > 0 보장.
    pass # 굳이 H=0.0으로 설정할 필요 없음
elif V == R:
    H = (60 * (G - B)) / delta
elif V == G:
    H = 120 + (60 * (B - R)) / delta
elif V == B:
    H = 240 + (60 * (R - G)) / delta

# H 범위 조정 (0 <= H < 360)
while H < 0:
    H += 360
while H >= 360: # 문제 조건에서 H는 항상 -360 < H < 360이므로 while H >= 360은 사실상 불필요
    H -= 360

# 진정한™ 보라색 판별
is_true_purple = False
if h_lo <= H <= h_hi and s_lo <= S <= s_hi and v_lo <= V <= v_hi:
    is_true_purple = True

# 결과 출력
if is_true_purple:
    print("Lumi will like it.")
else:
    print("Lumi will not like it.")