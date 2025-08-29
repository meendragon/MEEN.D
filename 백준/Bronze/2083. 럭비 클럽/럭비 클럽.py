import sys

while True:
    name, age, weight = sys.stdin.readline().split()
    age = int(age)
    weight = int(weight)

    if name == "#" and age == 0 and weight == 0:
        break

    if age > 17 or weight >= 80:
        print(f"{name} Senior")
    else:
        print(f"{name} Junior")