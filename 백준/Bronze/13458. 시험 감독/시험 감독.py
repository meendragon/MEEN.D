import sys
input  = sys.stdin.readline
n = int(input())
classroom = list(map(int,input().split()))
B,C = map(int,input().split())
count = n
for students in classroom:
    if students <= B:
        continue
    count += (students-B)//C
    if (students-B)%C != 0:
        count += 1

print(count)