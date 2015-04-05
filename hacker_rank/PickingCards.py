# link: https://www.hackerrank.com/challenges/picking-cards
# name: Picking Cards
__author__ = 'mislav'


def solve(card_values):
    modulo = 1000000007
    sorted_values = sorted(card_values)

    result = 1
    end = 0
    for picked in xrange(len(sorted_values)):
        while end < len(sorted_values) and sorted_values[end] <= picked:
            end += 1

        if end <= picked:
            result = 0
            break

        result = (result * (end - picked)) % modulo
    return result

if __name__ == "__main__":
    test_count = int(raw_input())

    for _ in xrange(test_count):

        raw_input()  # skip
        input_data = [int(x) for x in raw_input().split()]
        print solve(input_data)