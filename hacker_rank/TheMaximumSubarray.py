__author__ = 'mislav'


def get_positive_sum(max_single, input_array):

    positives = [positive for positive in input_array if positive > 0]
    result = max_single
    if len(positives) > 0:
        result = sum(positives)

    return result


def get_maximum_contiguous(max_single, input_array):
    current_result = 0
    best_result = max_single

    for x in input_array:
        if current_result < 0:
            current_result = 0

        current_result += x
        if current_result > best_result:
            best_result = current_result

    return best_result


def solve(input_array):

    max_single = max(input_array)
    print str(get_maximum_contiguous(max_single, input_array)) + " " + str(get_positive_sum(max_single, input_array))


if __name__ == "__main__":
    test_count = int(raw_input())
    for x in xrange(test_count):
        n = raw_input()  # skip
        input_data = raw_input()
        input_array = [int(x) for x in input_data.split()]
        solve(input_array)