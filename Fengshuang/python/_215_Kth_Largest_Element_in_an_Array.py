class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        from queue import PriorityQueue
        q = PriorityQueue()
        for i in nums:
            q.put(i)
            if q.qsize() > k:
                q.get()
        return q.get()