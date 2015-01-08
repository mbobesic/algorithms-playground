__author__ = 'mislav'

# you can use print for debugging purposes, e.g.
# print "this is a debug message"


def solution(A):
    # write your code in Python 2.7
    result = 0
    last = A[0]

    exists = set()

    for x in A:
        abs_x = abs(x)
        if abs_x in exists:
            continue
        result += 1
        exists.add(abs_x)

    return result