import sys

line_input = sys.stdin.readline().split()
n = int(line_input[0])
name = line_input[1]


word = {}
new_name_list = []
count = 0
for i in range(len(name)):
    if not name[i] in word:
        word[name[i]] = i
        new_name_list.append(name[i])
    else:
        count+=1


new_name_list.append(str(count+4))
number = 1906+n
number_list = str(number)

ans = number_list + "".join(new_name_list)
reversed_ans = ans[::-1]
id = "smupc_"

print(id + reversed_ans)