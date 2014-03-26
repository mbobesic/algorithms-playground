def solution(N, A):
    # write your code in Python 2.6
    solution = [0]*N
    
    max_value = 0
    min_value = 0
    
    for current in A:
        
        if current == N+1:
            min_value = max_value
        else:
            solution[current-1] = max(solution[current-1],min_value)+1
            max_value = max(max_value, solution[current-1])
    
    solution = map( lambda x: max(x,min_value), solution)
        
    return solution

