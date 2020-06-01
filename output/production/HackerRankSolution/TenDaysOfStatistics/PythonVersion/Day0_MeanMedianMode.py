def mean(numbers):
    return sum(numbers) / n


def mode(numbers):
    occurrences = {x: 0 for x in numbers}
    for x in range(n):
        if numbers[x] in occurrences:
            occurrences[numbers[x]] = occurrences[numbers[x]] + 1

    max_value_occurrence = 0
    max_value = []

    for i, j in occurrences.items():
        if j >= max_value_occurrence:
            max_value_occurrence = j
            max_value.append(i)
    return min(max_value)


def median(numbers):
    numbers.sort()
    x = numbers[int(n/2)]
    y = numbers[int((n - 1)/2)]
    return (x + y)/2.0


def start():
    global n
    n = int(input())
    elements = input()
    split = list(map(int, (val for val in elements.split() if val.isdigit())))
    return split


if __name__ == '__main__':
    x = start()

    value = "{:.1f}"
    print(value.format(mean(x)))
    print(value.format(median(x)))
    print(mode(x))
