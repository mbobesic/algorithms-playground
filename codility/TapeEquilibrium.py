# link: https://codility.com/demo/take-sample-test/tape_equilibrium
# name: Tape Equilibrium


def solution(A):
    # write your code in Python 2.6
    solution = sum(map(abs, A))
    total = sum(A)
  
    partial = 0;
    for index in range(len(A)-1):
        current = A[index]
        partial += current
        rest = total - partial
        possible = abs(partial - rest)
        solution = min(possible, solution)
        
    return solution
