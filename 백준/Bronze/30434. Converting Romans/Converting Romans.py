import sys

input = sys.stdin.readline

latin = {"I": 1, "V": 5, "X": 10, "L": 50,
         "C": 100, "D": 500, "M": 1000}

n = int(input())
for _ in range(n):
    s = input().strip()
    vals = [latin[c] for c in s]

    total = 0
    max_right = 0
    for v in reversed(vals):
        if v < max_right:
            total -= v
        else:
            total += v
            max_right = v
    print(total)