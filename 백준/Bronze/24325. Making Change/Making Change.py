import sys

n = int(sys.stdin.readline())
change = [50.0,20.0,10.0,5.0,1.0]
for _ in range(n):
    ans =[]
    a,b = map(float,sys.stdin.readline().split())
    sub = b - a
    for x in change:
        if sub // x > 0:
            temp = sub // x
            sub -= temp*x
            ans.append(int(temp))
        else:
            ans.append(0)

    for x,y in zip(ans,change):
        output_parts = [f"{x}-${int(y)}" for x, y in zip(ans, change)]
        result = ", ".join(output_parts)

    print(result)



