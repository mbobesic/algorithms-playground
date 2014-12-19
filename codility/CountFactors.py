__author__ = 'mislav'

from math import sqrt

def solution(N):
    # write your code in Python 2.7
    result = 0
    for index in xrange(1, int(sqrt(N))+ 1):
        if N % index == 0:
            result += 1
            if N/index != index:
                result += 1

    return result