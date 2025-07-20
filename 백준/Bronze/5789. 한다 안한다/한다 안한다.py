import sys
t = int(sys.stdin.readline().strip())
for i in range(t):
    flower = sys.stdin.readline().strip()
    n = len (flower)
    target = n//2
    if flower[target-1] == flower[target]:
        print("Do-it")
    else:
        print("Do-it-Not")