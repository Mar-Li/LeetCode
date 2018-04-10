# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num):

class Solution(object):
    def guessNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        return self._guessNumber(1, n + 1)

    def _guessNumber(self, start, end):
        if end - start <= 1:
            return start
        mid = int((start + end) / 2)
        result = guess(mid)
        if result == 0:
            return mid
        elif result == 1:
            return self._guessNumber(mid + 1, end)
        else:
            return self._guessNumber(start, mid)
