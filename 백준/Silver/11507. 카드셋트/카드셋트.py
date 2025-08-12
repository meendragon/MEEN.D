import sys

suits = ["P", "K", "H", "T"]
cards = {suit: set() for suit in ["P", "K", "H", "T"]}


line = sys.stdin.readline()

i = 0
while line[i] != '\n':
    curShape = line[i]
    curNum = int(line[i+1:i+3])
    if curNum in cards[curShape]:
        print('GRESKA')
        sys.exit(0)
    else:
        cards[curShape].add(curNum)
    i+=3

print(*(13-len(cards[s])for s in suits))
