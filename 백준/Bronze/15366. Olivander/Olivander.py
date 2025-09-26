import sys

n = int(sys.stdin.readline())
wand = list(map(int,sys.stdin.readline().split()))
box = list(map(int,sys.stdin.readline().split()))
wand.sort()
box.sort()
printDA = True
for i in range(n):
    if wand[i] > box[i]:
        printDA = False
        break

if printDA:
    print("DA")
else:
    print("NE")