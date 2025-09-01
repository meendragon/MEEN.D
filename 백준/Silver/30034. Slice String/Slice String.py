import sys

input = sys.stdin.readline

n = int(input())
sep1 = input().split()
m = int(input())
sep2 = input().split()
k = int(input())
k_list = input().split()
s = int(input())
line = input().rstrip()
delims = set(sep1 + sep2)
delims.add(" ")

for ch in k_list:
    if ch in delims:
        delims.remove(ch)

ans = []
for ch in line:
    if ch in delims:
        if ans:
            print("".join(ans))
            ans.clear()
    else:
        ans.append(ch)

if ans:
    print("".join(ans))