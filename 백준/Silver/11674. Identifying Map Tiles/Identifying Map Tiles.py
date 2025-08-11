import sys

line = sys.stdin.readline().rstrip()

lenn = len(line) #At first lenn is 3
sizee = pow(2,lenn)
x,y = sizee,sizee # they must 8
for i, j in zip(range(lenn, 0, -1), range(lenn)):
    temp = line[j]
    curMinus = pow(2,i-1)
    if temp == '0':
        x -= curMinus
        y -= curMinus
    elif temp == '1':
        y -= curMinus
    elif temp == '2':
        x -= curMinus

print(lenn, x-1,y-1)
