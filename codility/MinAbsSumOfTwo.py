# you can use print for debugging purposes, e.g.
# print "this is a debug message"

def solution(A):
    # write your code in Python 2.7
    a_sorted = sorted(A)
    
    end = len(A) - 1
    result = abs(a_sorted[0] + a_sorted[end])
    for index in xrange(len(A)):
        
        current = end
        current_result = abs(a_sorted[index] + a_sorted[current])
        while current >= 0 and abs(a_sorted[index] + a_sorted[current]) <= current_result:
            
            current_result = abs(a_sorted[index] + a_sorted[current])
            end = current
            current -= 1
        
        if current_result < result:
            result = current_result
    return result

