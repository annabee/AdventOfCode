from scripts import utils


# ASCII values for characters can be used as a proxy value holders
# ASCII for A = 65, Z = 90, a = 97, z = 122
def get_letter_value(char):
    if char.islower():
        return ord(char) - ord('a') + 1
    else:
        return ord(char) - ord('A') + 1


def main():
    test_input = utils.read_lines_from_file("../data/day3.txt")

    bags_with_compartments = []

    for line in test_input:
        middle_index = int(len(line)/2)
        bags_with_compartments.append([line[:middle_index], line[middle_index:]])

    common_in_compartments = [set(a).intersection(set(b)) for (a, b) in bags_with_compartments]

    # part 1
    print(sum([get_letter_value(char) for char in utils.flatten(common_in_compartments)]))

    grouped_rucksacks = utils.group_list_into_chunks(test_input, 3)
    common_in_rucksacks = [set(a).intersection(set(b)).intersection(set(c)) for (a, b, c) in grouped_rucksacks]

    #  part 2
    print(sum([get_letter_value(char) for char in utils.flatten(common_in_rucksacks)]))


if __name__ == "__main__":
    main()
