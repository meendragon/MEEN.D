import sys
n =int(sys.stdin.readline().strip())
for i in range(n):
    a, b, c = map(int,sys.stdin.readline().strip().split())
    min_value = (a+c)**2 + b**2
    if((b+c)**2 + a**2 < min_value):
        min_value = (b+c)**2 + a**2
    if((a+b)**2 + c**2 < min_value):
        min_value = (a+b)**2 + c**2
    print(min_value)
