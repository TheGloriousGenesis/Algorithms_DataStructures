import math


def binomial(n, x, p):
    constant = math.factorial(n) / (math.factorial(n - x) * math.factorial(x))
    return constant * pow(p, x) * pow((1 - p), (n - x))


def solution(arr):
    p = arr[0]/100
    n = int(arr[1])
    cum_2or_less = 0
    cum_2or_more = 0
    for i in range(0, 3, 1):
        cum_2or_less += binomial(n, i, p)
    for i in range(2, n + 1, 1):
        cum_2or_more += binomial(n, i, p)
    return cum_2or_less, cum_2or_more


if __name__ == '__main__':
    x = [float(i) for i in input().strip().split(' ')]
    value = "{:.3f}"
    y = solution(x)
    print(value.format(y[0]))
    print(value.format(y[1]))
