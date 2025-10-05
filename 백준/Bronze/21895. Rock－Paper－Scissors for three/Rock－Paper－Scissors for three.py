n = int(input())
a = input().strip()
b = input().strip()

res = ""
for i in range(n):
    x, y = a[i], b[i]
    if x == y:

        if x == 'R':
            res += 'P'
        elif x == 'P':
            res += 'S'
        else:
            res += 'R'
    else:

        s = {x, y}
        if s == {'R', 'S'}:
            res += 'R'
        elif s == {'S', 'P'}:
            res += 'S'
        elif s == {'P', 'R'}:
            res += 'P'
        else:
            res += 'R' 
print(res)