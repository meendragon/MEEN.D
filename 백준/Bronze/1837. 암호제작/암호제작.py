import sys

def solve():
    P, K = sys.stdin.readline().split()
    P = int(P)
    K = int(K)

    # K까지의 소수 판별을 위해 에라토스테네스의 체 사용
    is_prime = [True] * (K + 1)
    is_prime[0] = is_prime[1] = False

    for i in range(2, int(K**0.5) + 1):
        if is_prime[i]:
            for j in range(i*i, K + 1, i):
                is_prime[j] = False

    # 2부터 K-1까지의 소수로 P를 나누어봄
    for i in range(2, K):
        if is_prime[i]:
            if P % i == 0:
                print(f"BAD {i}")
                return

    # K-1까지의 소수로 나누어떨어지지 않으면 좋은 암호
    print("GOOD")

if __name__ == "__main__":
    solve()