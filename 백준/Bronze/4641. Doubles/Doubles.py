import sys

while True:
    line_input = sys.stdin.readline().strip()
    if line_input == "-1":
        break
    if not line_input:
        continue

    numbers = list(map(int, line_input.split()))
    if not numbers:
        continue
    numbers.sort()
    count = 0

    n = len(numbers)
    for i in range(n):
        for j in range(i + 1, n):
            if numbers[j] > numbers[i] * 2:
                break
            if numbers[j] == numbers[i] * 2:
                count += 1

    print(count)