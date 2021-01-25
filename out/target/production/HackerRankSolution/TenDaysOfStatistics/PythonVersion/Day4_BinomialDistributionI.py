from .tools.Tools import Tools


def binomial(n, x, p):
    constant = Tools.unordered_permutations(n, x)
    return constant * pow(p, x) * pow((1 - p), (n - x))


def solution(arr):
    p_b = arr[0] / sum(arr)
    n = 6
    cum = 0
    for i in range(3, 7, 1):
        cum += binomial(n, i, p_b)
    return cum


if __name__ == '__main__':
    x = [float(i) for i in input().strip().split(' ')]
    # p = 0.5
    #
    # y = binomial(x[0], x[1], p)
    # print(y)
    # cum = 0
    # for i in range(5, 11, 1):
    #     cum += binomial(x[0], i, p)
    # print(cum)
    value = "{:.3f}"
    print(value.format(solution(x)))
