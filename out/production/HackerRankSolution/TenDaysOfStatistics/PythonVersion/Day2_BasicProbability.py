def probability():
    die_1 = [1, 2, 3, 4, 5, 6]
    die_2 = [1, 2, 3, 4, 5, 6]
    count = 0
    bottom_frac = len(die_1) * len(die_2)
    for i in die_1:
        for j in die_2:
            # if i + j <= 9:
            if i + j == 6 and i != j:
                count += 1
    return count, bottom_frac


if __name__ == '__main__':
    x = probability()

    value = "{}/{}"
    print(value.format(probability()[0], probability()[1]))
