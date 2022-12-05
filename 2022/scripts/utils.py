def read_lines_from_file(file_path):
    with open(file_path) as f:
        return [line.strip() for line in f.readlines()]


def flatten(nested_list):
    return [item for sublist in nested_list for item in sublist]


def group_list_into_chunks(sequence, chunk_size):
    return list(zip(*[iter(sequence)] * chunk_size))

