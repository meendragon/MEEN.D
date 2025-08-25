import sys

T = int(input())
for _ in range(T):
    m,n = map(int, input().split())
    board = []
    for _ in range(n):
        line = list(map(int, input().split()))
        board.append(line)

    maxx = float("-inf")
    ansCol = 0
    for col in range(m):
        temp = 1
        for row in range(n):
            temp*=board[row][col]
        maxx = max(maxx, temp)
        if maxx == temp:
            ansCol = col

    print(ansCol+1)

