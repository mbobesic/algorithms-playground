def solution(A):
    # write your code in Python 2.6
    
    west = [0]*len(A)
    
    total = 0
    for index in range(len(A)):
        total += A[-index-1]
        west[-index-1] = total
    
    solution = 0
    for index in range(len(A)):
        if A[index] == 0:
            solution += west[index]
            
    if solution > 1000000000:
        return -1
    return solution
    
    
