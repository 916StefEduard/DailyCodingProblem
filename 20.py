

"""
Given a word s, reverse only all the vowels in the word and return it.

Input: s = "hello"
Output: "holle"

Constraints:
    - empty word ? - yes
    - no vowels ? - yes
Ideas:
    - we could have 2 pointers on at the start and one at the end
    - and we are going to check for vowels and then just change them up
"""


def checkVowel(character):
    if character == 'a' or character == 'e' or character == 'i' \
        or character == 'o' or character == 'u':
        return True
    return False

def change(word):
    first = 0
    word = list(word)
    last = len(word) - 1
    while first < last:
        while not checkVowel(word[first]) and first < last:
            first += 1
        while not checkVowel(word[last]) and first < last:
            last -= 1
        word[first], word[last] = word[last], word[first]
        first += 1
        last -= 1
    return ''.join(word)

s = "leetcode"
print(change(s))