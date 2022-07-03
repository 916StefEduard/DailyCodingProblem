

"""
Given the head of a singly linked list, return true if it is a palindrome.

ex: 1, 2, 2, 1
output: true

Constraints:
    - empty list? - yes

Ideas:
    - so first we are going to traverse the list and find the length
    - and then traverse it a second time and put the values in a stack
    until we get to the middle of the list and then strating popping
    if the values are equal
    - at the end ...
"""


class Node:
    def __init__(self, val):
        self.val = val
        self.next = None

def printList(root):
    current = root
    while current is not None:
        print(current.val)
        current = current.next

def getLength(root):
    currentLen = 0
    current = root
    while current is not None:
        currentLen += 1
        current = current.next
    return currentLen

def isPalindrome(root):
    listLength = getLength(root)
    stack = []
    current = root
    currentLength = 0
    while currentLength < listLength // 2:
        stack.append(current.val)
        current = current.next
        currentLength += 1
    if listLength % 2 == 1:
        current = current.next
    while len(stack) > 0 and current is not None:
        lastElement = stack[-1]
        if current.val == lastElement:
            stack.pop()
        current = current.next
    if len(stack) > 0:
        return False
    return True


root = Node(1)
root.next = Node(2)
root.next.next = Node(1)
#root.next.next.next = Node()
print(isPalindrome(root))