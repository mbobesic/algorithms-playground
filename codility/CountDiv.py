# link: https://codility.com/demo/take-sample-test/count_div
# name: Count Div
__author__ = 'mislav'

def solution(A, B, K):
    # write your code in Python 2.7
    result = B/K - A/K
    if A % K == 0:
        result += 1
    return result
