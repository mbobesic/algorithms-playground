__author__ = 'mislav'


def solution(A):
    # write your code in Python 2.7
    element_exists = [0]*100001

    for element in A:
        if element < 0:
            continue
        if element > 100000:
            continue
        element_exists[element] += 1

    for index in xrange(1, 100000):

        if element_exists[index] == 0:
            return index

    return 100001

print solution([1,3,6,4,1,2])