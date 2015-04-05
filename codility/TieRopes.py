# link: https://codility.com/demo/take-sample-test/tie_ropes
# name: Tie Ropes
__author__ = 'mislav'

# you can use print for debugging purposes, e.g.
# print "this is a debug message"

def solution(K, A):
    # write your code in Python 2.7

    result = 0
    curr = 0

    for x in A:
        curr += x
        if curr >= K:
            result += 1
            curr = 0
            continue


    return result