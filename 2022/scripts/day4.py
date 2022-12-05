from scripts import utils


def main():
    test_input = utils.read_lines_from_file("../data/day4.txt")

    pairs = []
    for line in test_input:
        pairs.append(line.split(','))

    overlapping_ranges = 0
    set_intersections = 0

    for left, right in pairs:
        left_lower, left_higher = left.split('-')
        right_lower, right_higher = right.split('-')

        left_set = set(range(int(left_lower), int(left_higher) + 1))
        right_set = set(range(int(right_lower), int(right_higher) + 1))

        set_intersection = left_set.intersection(right_set)

        if set_intersection:
            set_intersections += 1

            if set_intersection == left_set or set_intersection == right_set:
                overlapping_ranges += 1

    # part 1
    print(overlapping_ranges)

    # part 2
    print(set_intersections)


if __name__ == "__main__":
    main()
