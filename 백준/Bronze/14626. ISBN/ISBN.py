import sys

line = sys.stdin.readline().rstrip()
sum = 0
missing_index = 0
for i in range(len(line)):
    if line[i] == '*':
        missing_index = i
        continue
    if i%2 == 0:
        sum +=(int(line[i]))
    else:
        sum += 3*int(line[i])
rest = sum % 10
if missing_index % 2 !=0:
    temp = 10 - rest
    if temp % 3 == 0:
        ans = temp // 3
    elif temp % 3 == 1:
        temp += 20
        ans = temp // 3
    elif temp % 3 == 2:
        temp += 10
        ans = temp // 3

else:
    ans = 10 - rest

if ans == 10:
    ans = 0
print(ans)
