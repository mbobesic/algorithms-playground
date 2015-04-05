# link: https://codility.com/demo/take-sample-test/fib_frog
# name: FibFrog
__author__ = 'mislav'

# you can use print for debugging purposes, e.g.
# print "this is a debug message"


def solution(A):
    # write your code in Python 2.7
    max_size = 100001
    n = len(A)

    fibs = [0, 1]
    while fibs[-1] < n + 1:
        fibs.append(fibs[-1] + fibs[-2])

    A.append(1)
    result = [max_size]*(n+1)
    for index in xrange(n+1):
        if A[index] == 0:
            continue

        for fib in fibs:
            if index - fib < -1:
                break

            prev = index-fib

            if prev == -1:
                result[index] = 1
                break

            if result[prev] != max_size:
                result[index] = min(result[index], result[prev]+1)

    if result[-1] == max_size:
        return -1

    return result[-1]


print solution([0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0])
print solution([0, 0])
print solution([1, 1])
print solution([])