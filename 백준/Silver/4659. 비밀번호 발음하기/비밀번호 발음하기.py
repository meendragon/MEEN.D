import sys
vowel_list = ['a', 'e', 'i', 'o', 'u']
while(True):
    pw = sys.stdin.readline().rstrip()
    if pw == "end":
        break
    acceptable = True
    include_vowel = False
    vowel = 0
    consonant = 0
    ex = ""
    for i in range(len(pw)):
        temp = pw[i]
        if ex == temp and ex != "e" and ex != "o":
            acceptable = False
            break
        ex = temp
        if temp in vowel_list:
            vowel += 1
            consonant = 0
            include_vowel = True
        else:
            vowel = 0
            consonant += 1
        if vowel == 3 or consonant == 3:
            acceptable = False
            break

    if not include_vowel:
        acceptable = False
    if acceptable:
        print("<" + pw + ">" + " is acceptable.")
    else:
        print("<" + pw + ">" + " is not acceptable.")



