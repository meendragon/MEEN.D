import sys

line = sys.stdin.readline().rstrip()

dict = {
    'SONGDO' : 'HIGHSCHOOL',
    'CODE' : 'MASTER',
    '2023' : '0611',
    'ALGORITHM': 'CONTEST'
}

print(dict[line])