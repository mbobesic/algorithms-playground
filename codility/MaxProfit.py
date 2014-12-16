__author__ = 'mislav'

def solution(A):

    min_value = 200001
    result = 0
    for element in A:
        min_value = min(element, min_value)
        if element - min_value > result:
            result = element - min_value

    return result



print solution([23171, 21011, 21123, 21366, 21013, 21367])