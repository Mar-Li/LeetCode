# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head:
            return True
        l = []
        while head:
            l.append(head.val)
            head = head.next
        for i in range(int(len(l) / 2)):
            if l[i] != l[len(l) - i - 1]:
                return False
        return True