# link: https://codility.com/demo/take-sample-test/ladder
# name: Ladder

__author__ = 'mislav'

# you can use print for debugging purposes, e.g.
# print "this is a debug message"


def solution(A, B):
    # write your code in Python 2.7
    max_modulo = 2 ** 30
    fibs = [0] * (len(A)+2)

    fibs[1] = 1

    for index in xrange(2, len(A)+2):
        fibs[index] = (fibs[index-1] + fibs[index-2]) % max_modulo

    result =[]

    for index in xrange(len(A)):
        fib_val = fibs[A[index]+1]
        mod_val = 2 ** B[index]
        result.append(fib_val % mod_val)

    return result

