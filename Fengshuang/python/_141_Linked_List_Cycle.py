# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        one = head
        two = head
        while one and two:
            one = one.next
            two = two.next
            if two:
                two = two.next
            else:
                return False
            if not two:
                return False
            if one == two:
                return True
        return False