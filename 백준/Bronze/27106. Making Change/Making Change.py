P = int(input())

change = 100 - P

quarters = 0
dimes = 0
nickels = 0
pennies = 0

quarters = change // 25
change %= 25

dimes = change//10
change %= 10

nickels = change//5
change %= 5

pennies = change

print(quarters, dimes, nickels, pennies)