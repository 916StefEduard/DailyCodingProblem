

"""
Minimum depth of a binary tree

Input: root = [3,9,20,null,null,15,7]
Output: 2

     3
   /  \
  9   20
     /  \
    15   7

"""

class Tree:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


def preorder(root):
    if root is None:
        return
    print(root.val)
    preorder(root.left)
    preorder(root.right)


def minDepth(root):
    if root is None:
        return 0
    if root.left is None and root.right is None:
        return 1
    if root.left is None and root.right is not None:
        return 1 + minDepth(root.right)
    if root.left is not None and root.right is None:
        return 1 + minDepth(root.left)
    return 1 + min(minDepth(root.left), minDepth(root.right))


tree = Tree(1)
tree.left = Tree(2)
tree.right = Tree(3)
tree.right.right = Tree(4)
tree.left.left = Tree(5)
tree.left.left.left = Tree(100)
print(minDepth(tree.left))