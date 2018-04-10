class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        l = ListNode(None)
        root = l
        while l1 or l2:
            if (l1 is None and l2 is not None) or (l1 is not None and l2 is not None and l1.val >= l2.val):
                l.next = ListNode(l2.val)
                l = l.next
                l2 = l2.next
            if (l1 is not None and l2 is None) or (l1 is not None and l2 is not None and l1.val < l2.val):
                l.next = ListNode(l1.val)
                l = l.next
                l1 = l1.next
        return root.next