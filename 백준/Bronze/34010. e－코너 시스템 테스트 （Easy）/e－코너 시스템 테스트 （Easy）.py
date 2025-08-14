import sys

def main():
    input = sys.stdin.readline
    N = int(input().strip())

    for _ in range(2 * N - 1):
        input()

    dist = 2 * (N - 1)
    pivots = dist - 1
    print(dist, pivots)

if __name__ == "__main__":
    main()