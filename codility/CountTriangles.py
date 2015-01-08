__author__ = 'mislav'

# you can use print for debugging purposes, e.g.
# print "this is a debug message"

def solution(A):
    # write your code in Python 2.7
    a_sorted = sorted(A)

    result = 0
    print a_sorted
    for x in xrange(len(A)):
        z = 0
        for y in xrange(x+1, len(A)-1):
            if y > z:
                z = y + 1

            while z < len(A) and a_sorted[x] + a_sorted[y] > a_sorted[z] :
                z += 1

            result += z - (y + 1)

    return result