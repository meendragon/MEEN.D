def solve_checkerboard():
    """
    Reads checkerboard dimensions, rectangle heights, and widths, and
    prints the resulting checkerboard pattern.
    """
    # Read dimensions and number of rectangles
    r, c, v, h = map(int, input().split())

    # Read vertical heights
    vertical_heights = []
    for _ in range(v):
        vertical_heights.append(int(input()))

    # Read horizontal widths
    horizontal_widths = []
    for _ in range(h):
        horizontal_widths.append(int(input()))

    # Initialize the checkerboard grid
    board = [['' for _ in range(c)] for _ in range(r)]

    current_row = 0
    # Iterate through the vertical rectangles
    for i in range(v):
        current_col = 0
        # Iterate through the horizontal rectangles
        for j in range(h):
            # Determine the color based on the sum of indices
            # (i + j) % 2 == 0 for Black, (i + j) % 2 == 1 for White
            if (i + j) % 2 == 0:
                color = 'B'
            else:
                color = 'W'

            # Fill the current rectangle with the determined color
            for row in range(current_row, current_row + vertical_heights[i]):
                for col in range(current_col, current_col + horizontal_widths[j]):
                    board[row][col] = color

            # Move to the start of the next horizontal rectangle
            current_col += horizontal_widths[j]

        # Move to the start of the next vertical rectangle
        current_row += vertical_heights[i]

    # Print the final board
    for row in board:
        print(''.join(row))

solve_checkerboard()