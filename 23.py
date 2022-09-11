"""
Write a function to find the
longest common prefix string amongst an array of strings.

Added Complexity: O(m*n) + O(n)
Space: O(1)

Vertical alingment

"""

def findShort(list):
    min = 9999
    for i in list:
        if len(i) > min:
            min = len(i)
    return min

def solution(list):
    count = findShort(list)
    result = ""
    for i in range(count):
        first = list[0][i]
        for j in range(0, len(list)):
            if list[j][i] != first:
                return result
        result += first
    return result

print(solution(["geeks", "geke", "geeksforgeeks"]))