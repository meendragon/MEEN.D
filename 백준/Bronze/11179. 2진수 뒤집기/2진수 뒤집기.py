def solve():
    n = int(input())
    binary_representation = bin(n)[2:]
    reversed_binary = binary_representation[::-1]
    result = int(reversed_binary, 2)
    print(result)

solve()