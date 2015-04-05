# link: https://codility.com/demo/take-sample-test/count_semiprimes
# name: Count Semiprimes

__author__ = 'mislav'

def solution(N, P, Q):
    # write your code in Python 2.7
    primes_num = N
    sieve = [0]*(primes_num+2)
    prev_prim = [0] *(primes_num+2)
    next_prim = [0] *(primes_num+2)

    for index in xrange(2,primes_num+1):
        prev_prim[index] = index - 1
        next_prim[index] = index + 1

    current_out = 2
    while current_out * current_out <= primes_num:

        current_in = prev_prim[primes_num/current_out+1]
        while current_in >= current_out:
            sieve[current_in*current_out] = current_out
            next_prim[prev_prim[current_in*current_out]] = next_prim[current_in*current_out]
            prev_prim[next_prim[current_in*current_out]] = prev_prim[current_in*current_out]
            current_in = prev_prim[current_in]

        current_out = next_prim[current_out]

    semiprimes = [0]*(N+1)

    for index in xrange(2,N+1):
        if sieve[index] == 0:
            continue

        div_index = index/sieve[index]
        if sieve[div_index] == 0:
            semiprimes[index] = 1

    for index in xrange(1,len(semiprimes)):
        semiprimes[index] += semiprimes[index-1]

    result = []
    for index in xrange(len(P)):
        result.append(semiprimes[Q[index]] - semiprimes[P[index]-1])

    return result
