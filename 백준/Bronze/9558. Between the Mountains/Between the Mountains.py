import sys
t = int(sys.stdin.readline())
out_lines = []
for _ in range(t):
    line1 = list(map(int,sys.stdin.readline().split()))
    line2 = list(map(int,sys.stdin.readline().split()))
    mt1 = line1[1:]
    mt2 = line2[1:]
    mt1.sort()
    mt2.sort()
    i,j = 0,0
    ans = ex = 10**9 + 7
    while i < len(mt1) and j < len(mt2):
        diff = abs(mt1[i] - mt2[j])
        if diff < ans:
            ans = diff
            if ans == 0:
                break
        if mt1[i] < mt2[j]:
            i += 1
        else:
            j += 1

    out_lines.append(str(ans))

print("\n".join(out_lines))
