# link: https://codility.com/demo/take-sample-test/chocolates_by_numbers
# name: Chocolates By Numbers
__author__ = 'mislav'


def solution(N, M):
    # write your code in Python 2.7
    div = gcd(N,M)
    return N/div


def gcd(a, b):
    if a % b == 0:
        return b

    return gcd(b, a % b)

