import sys
import math

dice_a = list(map(int, sys.stdin.readline().split()))
dice_b = list(map(int, sys.stdin.readline().split()))

a_win = 0
for a_num in dice_a:
    for b_num in dice_b:
        if a_num >b_num:
            a_win += 1

total = 36
g = math.gcd(a_win, total)  # 최대공약수
a_win //= g
total //= g

print(f"{a_win}/{total}")