# Definition for a  binary tree node
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        node = root
        while node != None:
            self.stack.append(node)
            node = node.left
        

    def hasNext(self):
        """
        :rtype: bool
        """
        return len(self.stack) != 0
        

    def next(self):
        """
        :rtype: int
        """
        if not self.stack:
            return None
        last = self.stack[-1]
        if last.right == None:
            ret = self.stack.pop()
            result = ret.val
            if not self.stack:
                return result
            while ret == self.stack[-1].right:
                ret = self.stack.pop()
                if not self.stack:
                    return result
            return result
        elif last.right != None:
            result = last.val
            cur = last.right
            while cur != None:
                self.stack.append(cur)
                cur = cur.left
            return result
        

# Your BSTIterator will be called like this:
root = TreeNode(1)
a = TreeNode(2)
b = TreeNode(3)
c = TreeNode(4)
root.left = a
a.left = c
root.right = b
i, v = BSTIterator(root), []
while i.hasNext(): v.append(i.next())
print(v)