__author__ = 'mislav'

def solution(A):
    # write your code in Python 2.7

    n = len(A)
    if n == 1:
        return 0

    peaks = [0]*n

    for index in xrange(1, n-1):
        peaks[index] = peaks[index -1]
        if A[index] > A[index-1] and A[index] > A[index+1]:
            peaks[index] += 1

    peaks[-1] = peaks[-2]

    for x in xrange(2, int(n/2)+1):
        if n%x!= 0:
            continue
        last = 0
        for current in xrange(1,n/x + 1):
            if peaks[current * x - 1] == last:
                break

            if current * x == n:
                return n/x

            last = peaks[current*x -1]
    if peaks[-1] > 0:
        return 1

    return 0