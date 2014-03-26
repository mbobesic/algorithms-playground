def solution(S, P, Q):
    # write your code in Python 2.6
    
    help_length = (len(S)+1)
    As = [0] * help_length 
    Cs = [0] * help_length
    Gs = [0] * help_length
    Ts = [0] * help_length 
    
    matching = {'A':As, 'C':Cs, 'G':Gs, 'T': Ts}
    
    for index in range(len(S)):
        
        nucleotid = matching[S[index]]
        nucleotid[index+1] +=  1  
    
    for index in range(help_length):
        As[index] += As[index-1]
        Cs[index] += Cs[index-1]
        Ts[index] += Ts[index-1]
        Gs[index] += Gs[index-1]
    solution =[]
    
    for (x,y) in zip(P,Q):
        if As[y+1] - As[x] > 0:
            solution.append(1)
            continue
        if Cs[y+1] - Cs[x] > 0:
            solution.append(2)
            continue
        if Gs[y+1] - Gs[x] > 0:
            solution.append(3)
            continue
        if Ts[y+1] - Ts[x] > 0:
            solution.append(4)
            continue
        
    return solution
