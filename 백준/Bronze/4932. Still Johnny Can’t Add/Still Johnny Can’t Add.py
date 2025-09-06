import sys

n = int(sys.stdin.readline())

for num in range(n):
    size = int(sys.stdin.readline())
    board = [list(map(int, sys.stdin.readline().split())) for _ in range(size)]
    ans = "YES"
    for i in range(1,size):
        for j in range(1,size):
            if not board[i][j] == board[0][0] + (board[i][0] - board[0][0] + board[0][j] - board[0][0]):
                ans = "NO"
                break
        if ans == "NO":
             break

    print(f"{num+1}. {ans}")






