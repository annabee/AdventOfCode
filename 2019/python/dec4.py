from collections import Counter


def double_digits(numbers):
    for (x, y) in zip(numbers[:-1], numbers[1:]):
        if x == y:
            return True
    return False


def digits_increase(numbers):
    for (x, y) in zip(numbers[:-1], numbers[1:]):
        if x > y:
            return False
    return True


def double_digits_only_once(numbers):
    return 2 in Counter(numbers).values()


def main():
    input_values = [str(x) for x in range(128392, 643282)]
    print(sum([double_digits(num) and digits_increase(num) for num in input_values]))
    print(sum([double_digits_only_once(num) and digits_increase(num) for num in input_values]))


if __name__ == "__main__":
    main()
