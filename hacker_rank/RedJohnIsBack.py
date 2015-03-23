__author__ = 'mislav'


def solve(n):
    wall = [0]*(n+1)

    for x in xrange(n+1):

            if x == 0:
                wall[x] = 1
                continue

            if x-1 >= 0:
                wall[x] += wall[x-1]

            if x-4 >= 0:
                wall[x] += wall[x-4]

    global prime_numbers

    return wall[n] - sum(prime_numbers[:(wall[n]+1)]) - 1

if __name__ == "__main__":
    test_count = int(raw_input())

    prime_numbers = [0]*(217286+1)

    for x in xrange(2, len(prime_numbers)):
        multiplier = 2
        while multiplier * x < len(prime_numbers):
            prime_numbers[multiplier*x] = 1
            multiplier += 1

    for _ in xrange(test_count):
        print solve(int(raw_input()))