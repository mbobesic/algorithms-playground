__author__ = 'mislav'


def solve(amount, coins):
    solution = [0] * (amount + 1)
    solution[0] = 1

    for coin in coins:
        for index in xrange(len(solution)):
            if index - coin >= 0:
                solution[index] += solution[index - coin]

    return solution[-1]

if __name__ == "__main__":
        first_line = raw_input().split()
        n = int(first_line[0])
        m = int(first_line[1])
        coins = [int(x) for x in raw_input().split()]
        print solve(n, coins)