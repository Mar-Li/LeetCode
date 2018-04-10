# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        if not headA or not headB:
            return None
        la, lb = 0, 0
        ta, tb = headA, headB
        while ta:
            la += 1
            ta = ta.next
        while tb:
            lb += 1
            tb = tb.next
        ta, tb = headA, headB
        if la > lb:
            for i in range(la - lb):
                ta = ta.next
        else:
            for i in range(lb - la):
                tb = tb.next
        while ta:
            if ta == tb:
                return ta
            else:
                ta = ta.next
                tb = tb.next
        return None