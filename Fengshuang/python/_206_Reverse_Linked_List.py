# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return None
        root = ListNode(head.val)
        while head.next:
            head = head.next
            temp = ListNode(head.val)
            temp.next = root
            root = temp
        return root