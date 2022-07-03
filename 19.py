

"""
Given an integer n, return true if it is a power of two. Otherwise, return false.

Input: n = 1
Output: true

Constraints:
    - so we are going to divide n by 2 until we find subdivision of n % 2 != 0
    - or n == 1 (which that means n is a power of 2)
    - map to optimize the values and skip the values which we already computed
"""


def isPowerDynammic(n, mymap):
    if n <= 1:
        return True
    if n % 2 != 0:
        return False
    if n not in mymap:
        mymap[n] = isPowerDynammic(n//2, mymap)
    return mymap[n]

def check(n):
    mymap = {}
    if n <= 0:
        return False
    else:
        return isPowerDynammic(n, mymap)

number = 16
print(check(number))