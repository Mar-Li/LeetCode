# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        if not root:
            return None
        order = 0
        queue = [] # FILO
        while True:
            if not queue and order > 0:
                return None
            if not queue and order == 0:
                temp = root
                queue.append(root)
                while temp.left:
                    temp = temp.left
                    queue.append(temp)
                continue
            if queue:
                last = queue.pop()
                order += 1
                if order == k:
                    return last.val
                if last.right:
                    temp = last.right
                    queue.append(temp)
                    while temp.left:
                        temp = temp.left
                        queue.append(temp)
            
