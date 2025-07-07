import sys
def rotate(A,B,C,D):
    return C, A, D, B
A,B = map(int, sys.stdin.readline().strip().split())
C,D = map(int, sys.stdin.readline().strip().split())
max = A/C + B/D
count = 0
for i in range(3):
    A, B, C, D = rotate(A, B, C, D)
    temp = A/C + B/D
    if temp > max:
        max = temp
        count = i+1

print(count)
