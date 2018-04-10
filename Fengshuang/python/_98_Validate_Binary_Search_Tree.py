# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def isValid(node, min_value, max_value):
            if node == None:
                return True
            if node.left != None:
                if node.left.val < node.val and (min_value is None or node.left.val > min_value):
                    if not isValid(node.left, min_value, node.val):
                        return False
                else:
                    return False
            if node.right != None:
                if node.right.val > node.val and (max_value is None or node.right.val < max_value):
                    if not isValid(node.right, node.val, max_value):
                        return False
                else:
                    return False
            return True
        return isValid(root, None, None)
