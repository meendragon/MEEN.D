import sys

while 1:
    n = int(sys.stdin.readline())
    if n==-1:break
    exTime = 0
    distance = 0
    for i in range(n):
        speed, time = map(int,sys.stdin.readline().split())
        distance += (time-exTime)*speed
        exTime = time
    print(str(distance) + " miles")
