def start():
    global n
    n = int(input())
    numbers = [int(i) for i in input().strip().split(' ')]
    weights = [int(i) for i in input().strip().split(' ')]
    return numbers, weights


def weighted_mean(n, x, y):
    value = 0
    for i in range(n):
        value = value + (x[i] * y[i])
    return value/sum(y)


if __name__ == '__main__':
    x, y = start()

    value = "{:.1f}"
    print(value.format(weighted_mean(n, x, y)))
