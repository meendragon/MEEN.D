def solve():
    s = input()
    total_sum = 0
    count = 0
    i = 0
    while i < len(s):
        if s[i] == '1' and i + 1 < len(s) and s[i+1] == '0':
            total_sum += 10
            i += 2
        else:
            total_sum += int(s[i])
            i += 1
        count += 1

    if count > 0:
        average = total_sum / count
        print(f"{average:.2f}")

solve()