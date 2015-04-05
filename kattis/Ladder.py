# link: https://open.kattis.com/problems/ladder
# name: Ladder
__author__ = 'mislav'

from math import sin, radians, ceil


def get_ladder_height(wall_height, angle):
    angle_in_radians = radians(angle)
    exact_height = wall_height/sin(angle_in_radians)
    return int(ceil(exact_height))


if __name__ == "__main__":
    input_line = raw_input()
    inputs = [int(s) for s in input_line.split()]

    print get_ladder_height(inputs[0], inputs[1])