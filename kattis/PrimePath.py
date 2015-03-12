__author__ = 'mislav'

from collections import deque

MAX_VALUE = 10000
digits = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']


def get_transforms(number):
    result = []

    ns = str(number)
    for x in xrange(4):
        current = list(ns)
        for y in digits:
            current[x] = y
            num = int("".join(current))
            if num < 1000:
                continue
            if num == number:
                continue

            result.append(num)
    return result

if __name__ == "__main__":

    primes = [0]*(MAX_VALUE+2)
    prev = [0]*(MAX_VALUE+2)
    next = [0]*(MAX_VALUE+2)

    for x in xrange(2, MAX_VALUE):
        prev[x] = x - 1
        next[x] = x + 1

    i = 2
    while i * i <= MAX_VALUE:

        j = prev[MAX_VALUE // i + 1]
        while j >= i:
            primes[j * i] = i
            next[prev[j * i]] = next[j * i]
            prev[next[j * i]] = prev[j * i]
            j = prev[j]

        i = next[i]

    n = int(raw_input())
    while n > 0:
        n -= 1

        in_string = raw_input().split()
        start = int(in_string[0])
        end = int(in_string[1])

        q = deque([(start, 0)])
        visited = [False] * MAX_VALUE
        result = 0
        while len(q) > 0:
            current = q.popleft()

            if current[0] == end:
                result = current[1]
                break

            for transform in get_transforms(current[0]):
                if visited[transform]:
                    continue
                visited[transform] = True
                if primes[transform] != 0:
                    continue

                q.append((transform, current[1]+1))

        print result