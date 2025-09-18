import sys

def solve():
    # 입력 받기
    N, M = map(int, sys.stdin.readline().split())
    A = list(map(int, sys.stdin.readline().split()))
    B = list(map(int, sys.stdin.readline().split()))
    
    # A와 B의 모든 값을 더함
    total_cost = sum(A) + sum(B)
    
    # 결과 출력
    print(total_cost)

if __name__ == "__main__":
    solve()