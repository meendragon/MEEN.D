import sys

n = int(input())
nums = list(map(int, input().split()))
subSum = []
temp = 0
for num in nums:
    temp+=num
    subSum.append(temp)
m = int(input())
for _ in range(m):
    start, end = map(int,input().split())
    if start == 0:
        print(subSum[end])
    else:
        print(subSum[end] - subSum[start-1])

