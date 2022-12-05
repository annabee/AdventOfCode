from scripts import utils


def main():

    test_input = utils.read_lines_from_file("../data/day1.txt")

    list_of_elves_bags = []
    elf_bag = []

    for elem in test_input:
        if elem:
            elf_bag.append(int(elem))
        else:
            list_of_elves_bags.append(elf_bag)
            elf_bag = []

    calories_totals_per_bag = sorted([sum(bag) for bag in list_of_elves_bags])

    #  part 1
    print(calories_totals_per_bag[-1])
    #  part 2    
    print(sum(calories_totals_per_bag[-3:]))


if __name__ == "__main__":
    main()
