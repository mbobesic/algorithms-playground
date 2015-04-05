# link: https://codility.com/demo/take-sample-test/frog_river_one
# name: Fog River One


def solution(X, A):
    
    filled = [0]*(X+1)
    left = X
    
    for index in range(len(A)):
        current = A[index]
        if current <=X and filled[current] == 0:
            left -=1
            filled[current] = 1
        
        if left == 0:
            return index
            
    return -1

