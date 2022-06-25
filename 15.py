"""
Given a binary tree, determine if it is height-balanced.

Input: root = [3,9,20,null,null,15,7]
Output: true
"""


class Tree():
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def height(root):
    if root is None:
        return 0
    else:
        return 1 + max(height(root.left), height(root.right))


def isBalanced(root):
    if root is None:
        return True
    else:
        if abs(height(root.left) - height(root.right)) <= 1 and isBalanced(root.left) \
                and isBalanced(root.right):
            return True
        return False


tree = Tree(1)
tree.left = Tree(2)
tree.right = Tree(3)
tree.left.left = Tree(4)
print(isBalanced(tree))
