# Can be improved
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        result = []
        for i in range(2 ** (2 * n)):
            push_time = 0
            push_minus_pop = 0
            for j in range(2 * n):
                if (i >> j) & 1 == 1:
                    push_time += 1
                    push_minus_pop += 1
                else:
                    push_minus_pop -= 1
                if push_time > n or push_minus_pop < 0:
                    break
            else:
                result.append(i)
        result_str = []
        for i in result:
            s = ""
            for j in range(2 * n):
                if (i >> j) & 1 == 1:
                    s += '('
                else:
                    s += ')'
            result_str.append(s)
        return result_str

s = Solution()
print(s.generateParenthesis(3))