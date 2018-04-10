class MinStack(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = None

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.stack.append(x)
        if self.min == None or self.min > x:
            self.min = x
        

    def pop(self):
        """
        :rtype: void
        """
        if not self.stack:
            return None
        v = self.stack.pop()
        if not self.stack:
            self.min = None
        elif self.min == v:
            self.min = min(self.stack)

    def top(self):
        """
        :rtype: int
        """
        if not self.stack:
            return None
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        if not self.stack:
            return None
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()