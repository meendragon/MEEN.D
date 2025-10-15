import sys

n = sys.stdin.readline()
num_list=[cha for cha in n]
num_list.sort(reverse=True)
print(*num_list,sep='')