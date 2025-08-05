import sys
googlerese_to_english = {
    'y': 'a', 'e': 'o', 'q': 'z',
    'z': 'q', 'j': 'u', 'p': 'r',
    'm': 'l', 's': 'n', 'l': 'g',
    'c': 'e', 'k': 'i', 'd': 's',
    'x': 'm', 'v': 'p', 'n': 'b',
    'r': 't', 'i': 'd', 'b': 'h',
    't': 'w', 'a': 'y', 'h': 'x',
    'w': 'f', 'f': 'c', 'o': 'k',
    'u': 'j', 'g': 'v'
}

T = int(sys.stdin.readline())

for i in range(T):
    translated_text = ""
    input_line = sys.stdin.readline().strip()
    for char in input_line:
        if char in googlerese_to_english:
            translated_text += googlerese_to_english[char]
        else:
            translated_text += char

    print("Case #" + str(i+1) + ": " + translated_text)


