def solve():
    while True:
        line = input()
        if line == '#':
            break
        
        vowels = "aeiouAEIOU"
        count = 0
        for char in line:
            if char in vowels:
                count += 1
        
        print(count)

solve()