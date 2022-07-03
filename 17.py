

"""
Given the root of a binary tree,
return all root-to-leaf paths
in any order.

ex:
    1
   /  \
  2   3
   \
    5
Output: [ 1->2->5, 1->3]

"""


class Tree:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


def allPaths(root):
    if not root:
        return []
    stack = []
    stack.append((root, str(root.val)))
    final = []
    while stack:
        node, path = stack.pop()
        if not node.left and (not node.right):
            final.append(path)
        if node.left:
            stack.append((node.left, path + "->" + str(node.left.val)))
        if node.right:
            stack.append((node.right, path + "->" + str(node.right.val)))
    return final

root = Tree(1)
root.left = Tree(2)
root.right = Tree(3)
root.left.left = Tree(4)
root.left.right = Tree(5)
print(allPaths(root))