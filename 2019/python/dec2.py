program = [
    1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 10, 1, 19, 2, 19, 6, 23, 2, 13, 23, 27, 1, 9, 27, 31, 2, 31, 9,
    35, 1, 6, 35, 39, 2, 10, 39, 43, 1, 5, 43, 47, 1, 5, 47, 51, 2, 51, 6, 55, 2, 10, 55, 59, 1, 59, 9, 63, 2, 13, 63,
    67, 1, 10, 67, 71, 1, 71, 5, 75, 1, 75, 6, 79, 1, 10, 79, 83, 1, 5, 83, 87, 1, 5, 87, 91, 2, 91, 6, 95, 2, 6, 95,
    99, 2, 10, 99, 103, 1, 103, 5, 107, 1, 2, 107, 111, 1, 6, 111, 0, 99, 2, 14, 0, 0
]


def run(op_index, input_program):
    operation = input_program[op_index]
    if operation == 1:
        input_program[input_program[op_index + 3]] = input_program[input_program[op_index + 1]] + input_program[input_program[op_index + 2]]
        return run(op_index + 4, input_program)
    elif operation == 2:
        input_program[input_program[op_index + 3]] = input_program[input_program[op_index + 1]] * input_program[input_program[op_index + 2]]
        return run(op_index + 4, input_program)
    elif operation == 99:
        return input_program[0]
    else:
        raise RuntimeError("invalid code")


def main():
    input_program = program.copy()
    input_program[1] = 12
    input_program[2] = 2

    print(run(0, input_program))

    for noun in range(0, 100):
        for verb in range(0, 100):
            input_program = program.copy()
            input_program[1] = noun
            input_program[2] = verb

            if run(0, input_program) == 19690720:
                print(100 * noun + verb)


if __name__ == "__main__":
    main()
