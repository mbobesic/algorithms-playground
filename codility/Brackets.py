# link: https://codility.com/demo/take-sample-test/brackets
# name: Brackets
opening = ['(','{','[']
closing = [')','}',']']

def solution(S):
    # write your code in Python 2.6
    stack = []
    if len(S) == 0:
        return 1
        
    for x in S:
        if x in opening:
            stack.append(x)
            continue
        
        if len(stack)== 0:
            return 0
        
        for a,b in zip(opening, closing):
            if x == b and stack[-1] != a:
                return 0
        stack.pop()    
            
    if len(stack) == 0:
        return 1
        
    return 0
    
    

