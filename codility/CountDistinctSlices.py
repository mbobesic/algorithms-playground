__author__ = 'mislav'

# you can use print for debugging purposes, e.g.
# print "this is a debug message"

def solution(M, A):
    # write your code in Python 2.7

    occured = [0]  * (M + 1)

    start = 0
    result = 0
    for index in xrange(len(A)):
        element = A[index]

        if occured[element] == 1:
            for x in xrange(start, index):
                occured[A[x]] = 0
                if A[x] == element:
                    start = x + 1
                    break


        result += index - start + 1
        occured[element] += 1

    return min(result, 1000000000)

