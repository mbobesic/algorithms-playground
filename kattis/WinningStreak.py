__author__ = 'mislav'


def solve(match_count, win_probability):
    pass


if __name__ == "__main__":
    lines = []
    while len(lines) < 1:
        try:
            lines.append(raw_input())
        except EOFError:
            break

    for line in lines:
        data = line.split()
        print solve(int(data[0]), float(data[1]))