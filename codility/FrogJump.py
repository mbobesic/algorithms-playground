# link: https://codility.com/demo/take-sample-test/frog_jmp
# name: Frog Jump
import math

def solution(X, Y, D):
    # write your code in Python 2.6
    
    distance = Y - X
    solution = math.ceil(distance/float(D))
    return int(solution)

