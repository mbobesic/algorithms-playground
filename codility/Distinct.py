# link: https://codility.com/demo/take-sample-test/distinct
# name:Distinct


def solution(A):
    
    if len(A) == 0:
        return 0
    
    sorted_a = sorted(A)
    
    result = 1
    current = sorted_a[0]
    
    for x in sorted_a:
        if x!= current:
            result +=1
            current = x
    
    
    return result
    

