"""
Write a function to find the
longest common prefix string amongst an array of strings.

Added Complexity: O(m*n) + O(n)
Space: O(1)


"""


def func(index, curr, s, res):
    if index == len(s):
        res.append(curr)
        return
    if s[index].isalpha():
        if s[index].isupper():
            func(index + 1, curr + s[index].lower(), s, res)
        else:
            func(index + 1, curr + s[index].upper(), s, res)
    func(index + 1, curr + s[index], s, res)

res = []
curr = ""
index = 0
s = "a1b1"
func(index, curr, s, res)
print(res)
