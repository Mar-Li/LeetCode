# Complete the function below.

def minMoves(avg):
    sum1 = sum2 = count = 0
    for i, num in enumerate(avg):
        if num == 1:
            count += 1
            sum1 += i
            sum2 += len(avg) - i - 1
    return min(int(sum1 - count * (count - 1) / 2), int(sum2 - count * (count - 1) / 2))

print(minMoves([1,1,1,1,0,0,0,0]))
print(minMoves([1,1,1,1,0,1,0,1]))
print(minMoves([1,0,1,0,0,0,0,1]))