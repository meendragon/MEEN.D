import sys
count = 0
for i in range(8):
    line = sys.stdin.readline()
    for j in range(8):
        cur = line[j]
        if cur == 'F' and (i+j) % 2 == 0:
            count+=1

print(count)