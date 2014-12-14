__author__ = 'mislav'


def solution(H):
    # write your code in Python 2.6

    stack = [0]

    result = 0

    for x in H:
        while x < stack[-1]:
                stack.pop()

        if x == stack[-1]:
            continue

        result += 1
        stack.append(x)

    return result
