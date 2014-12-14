__author__ = 'mislav'

def solution(A, B, K):
    # write your code in Python 2.7
    result = B/K - A/K
    if A % K == 0:
        result += 1
    return result
