__author__ = 'mislav'

if __name__ == "__main__":
    test_count = int(raw_input())
    for x in xrange(test_count):
        first_line = raw_input().split()
        n = int(first_line[0])
        k = int(first_line[1])
        arr = [int(x) for x in raw_input().split()]
        dp = [0] * (k+1)

        for position in xrange(1, k+1):
            dp[position] = dp[position - 1]
            for value in arr:
                if position - value >= 0 and dp[position-value] + value > dp[position]:
                    dp[position] = dp[position-value] + value

        print dp[-1]