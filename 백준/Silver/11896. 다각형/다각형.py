import sys

a,b = map(int,sys.stdin.readline().split())

if a < 3:
    a = 3
if b < 3:
    b = 3

if a%2 != 0:
    a = a+1
if b%2 != 0:
    b = b-1
t = (b-a)//2 + 1

ans = (a+b) // 2 * t


print(int(ans))