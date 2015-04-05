# link: https://codility.com/demo/take-sample-test/min_avg_two_slice
# name: Min Avg Two Slice


def solution(A):
    # write your code in Python 2.6
    
    n = len(A)
    
    right = [0]*n
    
    for index in xrange(1,n+1):
        right[-index] = right[-index+1] + A[-index]
    
    right.append(0)
    solution = sum(A)/float(n)
    result = 0
    
    for index in xrange(0,n-1):
        possible_solution = (right[index]-right[index+2])/float(2) 
        if possible_solution < solution:
            solution = possible_solution
            result = index
        
        if index == n-2:
            continue
        
        possible_solution = (right[index]-right[index+3])/float(3) 
        if possible_solution < solution:
            solution = possible_solution
            result = index
    
    return result

