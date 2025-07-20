import sys
from collections import deque
n = int(sys.stdin.readline().strip())
my_deque = deque()
temp_deque = deque()
temp = list(map(int, sys.stdin.readline().strip().split()))
for i in range(n):
    for j in range(temp[i]):
        temp_deque.append(my_deque.pop())
    my_deque.append(i+1)
    while(len(temp_deque) > 0):
        my_deque.append(temp_deque.pop())

while(len(my_deque) > 0):
    print(my_deque.popleft(),end = ' ')

