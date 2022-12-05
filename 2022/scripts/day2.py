from scripts import utils


choice_score = {
    'X': 1,
    'Y': 2,
    'Z': 3
}

wins = {
    'A': 'Y',
    'B': 'Z',
    'C': 'X'
}
draws = {
    'A': 'X',
    'B': 'Y',
    'C': 'Z'
}
loses = {
    'A': 'Z',
    'B': 'X',
    'C': 'Y'
}

outcome = {
    'X': 0,
    'Y': 3,
    'Z': 6
}


def win_or_lose_score(col1, col2):
    if wins[col1] == col2:
        return 6
    elif draws[col1] == col2:
        return 3
    else:
        return 0


def find_shape(col1, col2):
    if col2 == 'X':
        return loses[col1]
    elif col2 == 'Y':
        return draws[col1]
    else:
        return wins[col1]


def main():

    test_input = utils.read_lines_from_file("../data/day2.txt")
    guide = [line.split(' ') for line in test_input]

    for (col1, col2) in guide:
        print([col1, col2])

    scores = [win_or_lose_score(col1, col2) + choice_score[col2] for (col1, col2) in guide]

    scores2 = [outcome[col2] + choice_score[find_shape(col1, col2)] for (col1, col2) in guide]

    # part 1
    print(sum(scores))
    # part 2
    print(sum(scores2))


if __name__ == "__main__":
    main()
