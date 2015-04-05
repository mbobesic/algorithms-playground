# link: https://www.hackerrank.com/challenges/stockmax
# name: Stock Maximize
__author__ = 'mislav'


def solve(prices):

    left_max = [0] *len(prices)
    left_max[-1] = prices[-1]
    for x in xrange(len(prices)-2, -1, -1):
        if prices[x] > left_max[x+1]:
            left_max[x] = prices[x]
            continue

        left_max[x] = left_max[x+1]

    result = 0
    for index in xrange(len(prices)):
        result += left_max[index] - prices[index]

    return result

if __name__ == "__main__":
    test_count = int(raw_input())

    for _ in xrange(test_count):

        raw_input()  # skip
        input_data = [int(x) for x in raw_input().split()]
        print solve(input_data)