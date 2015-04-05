# link: https://codility.com/demo/take-sample-test/number_solitaire
# name: Number Solitare
__author__ = 'mislav'

# you can use print for debugging purposes, e.g.
# print "this is a debug message"


def solution(A):
    # write your code in Python 2.7
    n = len(A)
    result = [0] * n
    result[0] = A[0]
    for index in xrange(1,n):
        max_val = -1000000001
        for max_it in xrange(6):
            if index - max_it - 1 < 0:
                break

            if result[index-max_it-1] > max_val:
                max_val = result[index-max_it-1]

        result[index] = max_val + A[index]

    return result[-1]