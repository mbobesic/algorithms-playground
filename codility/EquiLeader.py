__author__ = 'mislav'


def solution(A):
    # write your code in Python 2.7

    stack = []
    counts = {}
    n = len(A)
    candidates = [None] * n
    rev_candidates = [None] * n

    for index in xrange(n):
        count = 0
        value = A[index]
        if value in counts:
            count = counts[value]

        counts[value] = count + 1

        if len(stack) > 0 and value != stack[-1]:
            stack.pop()
        else:
            stack.append(value)

        if len(stack) > 0:
            candidates[index] = stack[-1]

    stack = []
    for index in xrange(n - 1, -1, -1):
        if len(stack) > 0 and A[index] != stack[-1]:
            stack.pop()
        else:
            stack.append(A[index])

        if len(stack) > 0:
            rev_candidates[index] = stack[-1]

    result = 0
    prefix_counts = {}
    for index in xrange(n-1):

        count = 0
        value = A[index]
        if value in prefix_counts:
            count = prefix_counts[value]

        prefix_counts[value] = count + 1

        if candidates[index] is None:
            continue
        if candidates[index] != rev_candidates[index+1]:
            continue

        candidate = candidates[index]
        if prefix_counts[candidate]*2 <= index + 1:
            continue
        if (counts[candidate] - prefix_counts[candidate])*2 <= n - index - 1:
            continue

        result += 1

    return result


print solution([1,2,1,1,2,1])
print solution([5,6,7,1,1,1,1,1,1,1,9,8,3])
print solution(range(100))
print solution([4,3,4,4,4,2])