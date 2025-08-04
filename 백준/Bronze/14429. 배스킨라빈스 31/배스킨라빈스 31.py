n = int(input())
games = [tuple(map(int, input().split())) for _ in range(n)]

min_turns = float('inf')
min_game_idx = -1

for i, (j, m) in enumerate(games):
    r = (j - 1) % (m + 1)
    count = 0
    num = r
    while num <= j - 1:
        count += 1
        num += (m + 1)
    if count < min_turns:
        min_turns = count
        min_game_idx = i + 1  # 1-based index

print(min_game_idx, min_turns*2)