# link: https://open.kattis.com/problems/different
# name: A Different Problem
__author__ = 'mislav'


if __name__ == "__main__":
    lines = []
    while True:
        try:
            lines.append(raw_input())
        except EOFError:
            break

    for line in lines:
        numbers = line.split()
        print abs(int(numbers[0]) - int(numbers[1]))
