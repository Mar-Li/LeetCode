# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if not head:
            return None
        array = []
        temp = head
        cnt = 0
        while temp:
            temp.cnt = cnt
            cnt += 1
            array.append(temp)
            temp = temp.next
        nodes = []
        for temp in array:
            nodes.append(RandomListNode(temp.label))
        for i in range(len(array)):
            if array[i].random:
                nodes[i].random = nodes[array[i].random.cnt]
        for i in range(len(array) - 1):
            nodes[i].next = nodes[i + 1]
        return nodes[0]