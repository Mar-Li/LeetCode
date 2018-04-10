# """
# This is the interface that allows for creating nested lists.
# You should not implement it, or speculate about its implementation
# """
#class NestedInteger(object):
#    def isInteger(self):
#        """
#        @return True if this NestedInteger holds a single integer, rather than a nested list.
#        :rtype bool
#        """
#
#    def getInteger(self):
#        """
#        @return the single integer that this NestedInteger holds, if it holds a single integer
#        Return None if this NestedInteger holds a nested list
#        :rtype int
#        """
#
#    def getList(self):
#        """
#        @return the nested list that this NestedInteger holds, if it holds a nested list
#        Return None if this NestedInteger holds a single integer
#        :rtype List[NestedInteger]
#        """

class NestedIterator(object):

    def __init__(self, nestedList):
        """
        Initialize your data structure here.
        :type nestedList: List[NestedInteger]
        """
        self.stack = []
        self.stack.append([nestedList, 0])

    def next(self):
        """
        :rtype: int
        """
        if not self.stack:
            return []
        l, index = self.stack[-1][0], self.stack[-1][1]
        while index >= len(l):
            self.stack.pop()
            if self.stack:
                l, index = self.stack[-1][0], self.stack[-1][1]
            else:
                return []
        if l[index].isInteger():
            result = l[index].getInteger()
            self.stack[-1][1] += 1
            return result
        else:
            self.stack[-1][1] += 1
            self.stack.append([l[index].getList(), 0])
            return self.next()


    def hasNext(self):
        """
        :rtype: bool
        """
        if not self.stack:
            return False
        l, index = self.stack[-1][0], self.stack[-1][1]
        while index >= len(l):
            self.stack.pop()
            if self.stack:
                l, index = self.stack[-1][0], self.stack[-1][1]
            else:
                return False
        if l[index].isInteger():
            return True
        else:
            self.stack[-1][1] += 1
            self.stack.append([l[index].getList(), 0])
            return self.hasNext()
        
        

# Your NestedIterator object will be instantiated and called as such:
# i, v = NestedIterator(nestedList), []
# while i.hasNext(): v.append(i.next())