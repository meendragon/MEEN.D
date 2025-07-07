import sys
strings =sys.stdin.readline().strip()
if strings == '(1)':
    print(0)
elif strings == ')1(':
    print(2)
else:
    print(1)
