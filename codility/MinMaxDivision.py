# link: https://codility.com/demo/take-sample-test/min_max_division
# name: Min Max Division
# you can use print for debugging purposes, e.g.
# print "this is a debug message"


def solution(K, M, A):
    # write your code in Python 2.7
    n = len(A)
    M = max(A) # trust no one
    end = n*M
    
    beg = 0
    result = n*M
    
    while end >= beg:
        mid = (beg+end)/2
     
        if check(A, K, M, mid):
            
            end = mid-1          
            result = mid
        else:
            beg = mid + 1

    return result
    

def check(A, K, M, possible_sol):
    
    if possible_sol < M:
        return False
    current_sum = 0
    result = 1
    for x in A:
        
        if current_sum + x > possible_sol:
            result += 1
            current_sum = x
            continue
        
        current_sum += x
    
    return result <= K

