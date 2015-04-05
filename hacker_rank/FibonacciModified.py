# link: https://www.hackerrank.com/challenges/fibonacci-modified
# name: Fibonacci Modified
__author__ = 'mislav'

if __name__ == "__main__":
    input_data = raw_input().split()
    a = int(input_data[0])
    b = int(input_data[1])
    n = int(input_data[2])

    values =[a, b]
    while len(values) < n:
        values.append(values[-1]*values[-1] + values[-2])

    print values[-1]