import sys

n = int(sys.stdin.readline())
gold  = False

while not gold:
    stringNum = str(n)
    curGold = True
    for char in stringNum:
        if char != '7' and char != '4':
            curGold = False

        if not curGold:
            break
    if curGold:
        gold = True
        print(stringNum)
    n-=1
