import sys


sum = 0
all_text = ""
while True:
    line = sys.stdin.readline().strip()
    if not line:
        break
    all_text+=line

for token in all_text.split(","):
    if token.isdigit():
        sum += int(token)
        
print(sum)