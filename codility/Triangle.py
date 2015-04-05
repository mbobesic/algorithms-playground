# link: https://codility.com/demo/take-sample-test/triangle
# name: Triangle

def solution(A):
    A.sort()
    
    for index in xrange(0,len(A)-2):
        if A[index]+A[index+1] > A[index+2]:
            return 1
            
    return 0
