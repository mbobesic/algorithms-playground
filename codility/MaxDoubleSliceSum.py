__author__ = 'mislav'


def solution(A):
    # write your code in Python 2.7
    n = len(A)

    max_endings = [0] * n
    inverted_endings = [0] * n

    max_ending = 0
    for index in xrange(1, n):
        x = A[index]
        if x > max_ending + x:
            max_ending = x
        else:
            max_ending = max_ending + x

        max_endings[index] = max_ending

    max_ending = 0
    for index in xrange(1, n):
        x = A[-1 - index]
        if x > max_ending + x:
            max_ending = x
        else:
            max_ending = max_ending + x

        inverted_endings[-1 - index] = max_ending

    max_slice = 0
    for index in xrange(1, n-1):
        left = max(max_endings[index - 1], 0)
        right = max(0, inverted_endings[index + 1])
        current_max = left + right
        if current_max > max_slice:
            max_slice = current_max
    return max_slice

print solution([3, 2, -6, 4, 0])
print solution([3, 2, 6, -1, 4, 5, -1, 2])
print solution([-3, -1, -2, -3, -4, -5])
print solution(range(-3, 3))
print solution(range(-4, 4))
print solution(range(-1001, 1001))