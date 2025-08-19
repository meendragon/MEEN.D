import sys

board = []
heart_r, heart_c = 0, 0
spine_r, spine_c = 0, 0

def find_heart(r, c):
    n = len(board)
    # 경계 체크
    if r - 1 < 0 or r + 1 >= n or c - 1 < 0 or c + 1 >= n:
        return False
    return (board[r+1][c] == '*' and
            board[r-1][c] == '*' and
            board[r][c+1] == '*' and
            board[r][c-1] == '*')

def find_length(r, c, direction):
    global spine_r, spine_c
    # 시작 위치 및 진행 방향 설정
    if direction == 'left_hand':
        c -= 1
        delta_r, delta_c = 0, -1
    elif direction == 'right_hand':
        c += 1
        delta_r, delta_c = 0, 1
    elif direction == 'spine':
        r += 1
        delta_r, delta_c = 1, 0
    elif direction == 'left_leg':
        r += 1
        c -= 1
        delta_r, delta_c = 1, 0
    elif direction == 'right_leg':
        r += 1
        c += 1
        delta_r, delta_c = 1, 0
    else:
        return 0

    cnt = 0
    n = len(board)
    # 경계 먼저 체크 후 전진
    while 0 <= r < n and 0 <= c < n and board[r][c] == '*':
        r += delta_r
        c += delta_c
        cnt += 1

    if direction == 'spine':
        spine_r = r - 1  # 마지막 '*' 위치
        spine_c = c

    return cnt

def main():
    global heart_r, heart_c, spine_r, spine_c
    n = int(sys.stdin.readline())
    for _ in range(n):
        board.append(sys.stdin.readline().strip())

    found = False
    for r in range(n):
        if found:
            break
        for c in range(n):
            if find_heart(r, c):
                heart_r, heart_c = r, c
                print(f"{r+1} {c+1}")
                found = True
                break

    part_name = ['left_hand', 'right_hand', 'spine']
    leg_name = ['left_leg', 'right_leg']
    ans = []
    for name in part_name:
        ans.append(find_length(heart_r, heart_c, name))
    for name in leg_name:
        ans.append(find_length(spine_r, spine_c, name))

    print(*ans)

if __name__ == "__main__":
    main()