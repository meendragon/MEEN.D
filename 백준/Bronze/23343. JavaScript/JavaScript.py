import sys

a,b = sys.stdin.readline().split()
if a.isdigit() and b.isdigit():
    print(int(a) - int(b))
else:
    print("NaN")