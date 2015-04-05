# link: https://codility.com/demo/take-sample-test/max_product_of_three
# name: Max Product Of Three


def solution(A):
    A.sort()
    return max(A[0]*A[1]*A[-1] , A[-1]*A[-2]*A[-3])
