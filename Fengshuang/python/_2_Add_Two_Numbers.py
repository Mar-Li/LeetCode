# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry = 0
        l = ListNode(0)
        root = l
        while(True):
            if (l1 == None and l2 == None):
                sum = 1
            elif (l1 == None):
                sum = l2.val + carry
                l2 = l2.next
            elif (l2 == None):
                sum = l1.val + carry
                l1 = l1.next
            else:
                sum = l1.val + l2.val + carry
                l1 = l1.next
                l2 = l2.next
            l.val = sum % 10
            carry = int(sum / 10)
            if (l1 == None and l2 == None and carry == 0):
                break
            l.next = ListNode(0)
            l = l.next
        return root

s = Solution()

a = ListNode(9)
a.next = ListNode(8)
b = ListNode(7)
b.next = ListNode(6)
b.next.next = ListNode(3)

r = s.addTwoNumbers(a,b)
print()