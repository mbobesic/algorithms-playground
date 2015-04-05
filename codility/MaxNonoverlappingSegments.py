# link: https://codility.com/demo/take-sample-test/max_nonoverlapping_segments
# name: Max Non Overlapping Segments

__author__ = 'mislav'

# you can use print for debugging purposes, e.g.
# print "this is a debug message"


def solution(A, B):
    # write your code in Python 2.7
    n = len(A)

    last_b = -1
    result = 0
    for index in xrange(n):
        if A[index] > last_b:
            result += 1
            last_b = B[index]

    return result