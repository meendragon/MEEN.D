import sys

r,c = map(int,sys.stdin.readline().split())

board = []

for i in range(r):
    row =[]
    for j in range(c):
        if (i+j) % 2 == 0:
            row.append('*')
        else:
            row.append('.')

    board.append(row)


for row in board:
    print(''.join(row))