# link: https://codility.com/demo/take-sample-test/min_perimeter_rectangle
# name: Min Perimeter Rectangle

__author__ = 'mislav'
from math import sqrt

def solution(N):
    # write your code in Python 2.7
    min_perimiter = (N + 1)* 2

    for x in xrange(1, int(sqrt(N))+1):
        if N % x == 0:
            solution = 2 * (x + (N/x))
            if solution < min_perimiter:
                min_perimiter = solution

    return min_perimiter

print solution(1)
print solution(30)
print solution(15486451)