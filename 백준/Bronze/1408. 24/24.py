import sys
current = sys.stdin.readline()
cur_tokens = list(map(int,current.strip().split(':')))

target = sys.stdin.readline()
target_tokens = list(map(int,target.strip().split(':')))

cur_sum = 60*60*cur_tokens[0] + 60*cur_tokens[1] + cur_tokens[2]

target_sum = 60*60*target_tokens[0] + 60*target_tokens[1] + target_tokens[2]

sub = target_sum - cur_sum
if sub<0:
    sub += 60*60*24
ans = []
ans.append(sub//3600)
sub -= ans[0]*3600
ans.append(sub//60)
sub -= ans[1]*60
ans.append(sub)
print(str(ans[0]).zfill(2) + ':' + str(ans[1]).zfill(2) + ':' + str(ans[2]).zfill(2))