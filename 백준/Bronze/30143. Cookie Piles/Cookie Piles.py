import sys

# 입력받을 테스트 케이스의 수 T
T = int(sys.stdin.readline())

# T번 반복
for _ in range(T):
    # N, A, D를 공백으로 구분하여 입력받기
    N, A, D = map(int, sys.stdin.readline().split())

    # 등차수열의 합 공식 적용
    total_cookies = N * (2 * A + (N - 1) * D) // 2

    # 결과 출력
    print(total_cookies)