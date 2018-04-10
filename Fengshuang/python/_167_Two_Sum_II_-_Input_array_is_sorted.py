class Solution:
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        a, b = 0, len(numbers) - 1
        while a < b:
            if numbers[a] + numbers[b] == target:
                return [a + 1, b + 1]
            elif numbers[a] + numbers[b] > target:
                b -= 1
            else:
                a += 1
