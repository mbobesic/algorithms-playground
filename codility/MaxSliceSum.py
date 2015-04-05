# link: https://codility.com/demo/take-sample-test/max_slice_sum
# name: Max Slice Sum
__author__ = 'mislav'


def solution(A):
    # write your code in Python 2.7

    max_slice = -1000001
    max_ending = -1000001

    for x in A:
        max_ending = max(x, max_ending + x)
        max_slice = max(max_slice, max_ending)

    return max_slice

print solution([3, 2, -6, 4, 0])