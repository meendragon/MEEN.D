import sys

def solve():
    # 입력 받기
    N, P = map(int, sys.stdin.readline().split())

    # 파이썬의 큰 수 연산 기능을 활용하여 N^P 계산
    result = N ** P

    # 결과를 문자열로 변환
    result_str = str(result)
    length = len(result_str)

    # 70자리씩 끊어서 출력
    for i in range(0, length, 70):
        print(result_str[i:i + 70])

# 함수 실행
solve()