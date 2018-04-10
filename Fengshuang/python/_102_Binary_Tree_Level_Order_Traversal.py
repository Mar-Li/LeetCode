# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        result = []
        def traverse(node, level):
            if len(result) < level:
                result.append([])
            result[level - 1].append(node.val)
            if node.left is not None:
                traverse(node.left, level + 1)
            if node.right is not None:
                traverse(node.right, level + 1)
        traverse(root, 1)
        return result