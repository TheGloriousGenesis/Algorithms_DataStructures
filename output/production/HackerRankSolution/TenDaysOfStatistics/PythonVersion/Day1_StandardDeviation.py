def start():
    global n
    n = int(input())
    numbers = [int(i) for i in input().strip().split(' ')]
    return numbers


def standard_deviation(n, x):
    mean = sum(x) / n
    diff_sq = [(i - mean)**2 for i in x]
    return (sum(diff_sq)/n)**(1/2)


if __name__ == '__main__':
    x = start()

    value = "{:.1f}"
    print(value.format(standard_deviation(n, x)))
