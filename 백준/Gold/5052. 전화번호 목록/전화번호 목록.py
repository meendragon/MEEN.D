import sys

t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    num_list = [sys.stdin.readline().strip() for _ in range(n)]
    num_list.sort()

    noFlag = False
    for i in range(n - 1):
        if num_list[i+1].startswith(num_list[i]):  # 접두어 검사
            print("NO")
            noFlag = True
            break
    if not noFlag:
        print("YES")