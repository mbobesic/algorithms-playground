# link: https://codility.com/demo/take-sample-test/dominator
# name: Dominator


def solution(A):
    # write your code in Python 2.6
    
    stack = []
    
    for x in A:
        if len(stack) > 0 and x != stack[-1]:
            stack.pop()
        else:
            stack.append(x)

    if len(stack) == 0:
        return -1
    
    candidate = stack[0]
    total = 0

    for x in A:
        if x == candidate:
            total += 1
            
    if total > len(A)/2:
        return A.index(candidate)
    else:
        return -1
        

