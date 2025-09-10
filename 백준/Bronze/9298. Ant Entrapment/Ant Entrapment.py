n = int(input())
for case in range(1, n + 1):
    ants = int(input())
    xs, ys = [], []
    for _ in range(ants):
        x, y = map(float, input().split())
        xs.append(x)
        ys.append(y)

    min_x, max_x = min(xs), max(xs)
    min_y, max_y = min(ys), max(ys)

    width = max_x - min_x
    height = max_y - min_y

    area = width * height
    perimeter = 2 * (width + height)

    print(f"Case {case}: Area {area}, Perimeter {perimeter}")