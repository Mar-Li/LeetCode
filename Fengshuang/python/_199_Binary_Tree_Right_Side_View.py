# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        result = []
        def traverse(node, depth):
            if depth > len(result):
                result.append(node.val)
            if node.right is not None:
                traverse(node.right, depth + 1)
            if node.left is not None:
                traverse(node.left, depth + 1)
        traverse(root, 1)
        return result