# link: https://codility.com/demo/take-sample-test/nesting
# name: Nesting


def solution(S):
    # write your code in Python 2.6
    
    if len(S) == 0:
        return 1
        
        
    stack = []
    
    for x in S:
        if x == '(':
            stack.append('(')
            continue
        
        if len(stack) == 0:
            return 0
        
        if stack[-1] == '(':
            stack.pop()
        else:
            stack.append(x)
            
    if len(stack) == 0:
        return 1
    
    return 0
    

