# you can use print for debugging purposes, e.g.
# print "this is a debug message"


def solution(A, B):
    # write your code in Python 2.7
    
    z = len(A)
    result = 0
    for index in xrange(z):
        a = A[index]
        b = B[index]
        d = gcd(a, b)
        if has_diff_factor(d, a):
            continue
        if has_diff_factor(d, b):
            continue
        result += 1
    
    return result


def has_diff_factor(a, b):
    div = gcd(a, b)
    while div != 1:
        b /= div
        div = gcd(a, b)
    return a % b != 0


def gcd(a, b):

    while a >= 0 and b >= 0:
        a_mod_b = a % b
        if a_mod_b == 0:
            return b
        a = b
        b = a_mod_b
    
    return 1

