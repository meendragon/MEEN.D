n = int(input())
cards = list(map(int, input().split()))
high_score = 0
sum = 0
for i in range(n):
    high_score = max(high_score, cards[i])
    sum+=cards[i]

ans = (n-1)*high_score
sum -= high_score
ans +=sum
print(ans)

