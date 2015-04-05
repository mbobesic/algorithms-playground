# link: https://codility.com/demo/take-sample-test/flags
# name: Flags

__author__ = 'mislav'

def solution(A):
    # write your code in Python 2.7
    n = len(A)
    if n < 3:
        return 0

    peaks = []

    for x in xrange(1,n-1):
        if A[x] > A[x-1] and A[x] > A[x+1]:
            peaks.append(x)


    result = 0
    for x in xrange(1,len(peaks)+1):

        if x*(x-1) > n:
            break

        flags_left = x
        last_peak = - 1 - x
        for peak in peaks:
            if x > peak - last_peak:
                continue

            last_peak = peak
            flags_left -=1
            if flags_left == 0:
                result = x
                break

    return result
