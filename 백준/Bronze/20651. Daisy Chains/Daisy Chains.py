import sys

def has_average_flower(flower):
    total = sum(flower)
    length = len(flower)
    if total % length != 0:
        return False
    avg = total // length
    return avg in flower

n = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))

count = 0
for i in range(n):
    for j in range(i, n):
        sub = nums[i:j+1]
        if has_average_flower(sub):
            count += 1

print(count)