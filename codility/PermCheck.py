# link: https://codility.com/demo/take-sample-test/perm_check
# name: Perm Check

def solution(A):
    
    help = [0] * len(A)
    
    for x in A:
        if x>len(A):
            return 0
            
        help[x-1] = 1
    
    for x in help:
        if x!=1:
            return 0
            
    return 1
        

