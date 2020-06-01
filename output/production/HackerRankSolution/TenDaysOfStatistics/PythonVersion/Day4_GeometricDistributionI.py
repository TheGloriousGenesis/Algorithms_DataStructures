import math
from .tools.Tools import Tools


# probability of probability of having (x -1) successes after (n -1) trials and having
# x successes after n trials.
# (n - 1, x -1) * p^x * q^(n-x)
def negative_binomial_distribution(n, x, p):
    # constant = tools.unordered_permutations(n - 1, x - 1)
    constant = math.factorial(n-1) / (math.factorial((n-1) - (x-1)) * math.factorial(x-1))
    return constant * pow(p, x) * pow((1 - p), (n - x))


# geometric distribution is a special case of negative binomial
# distribution where we count number of trials before a success
# X = 1 if the ith trial is a success otherwise 0 hence you can use
# X = 1 in negative binomial distribution
# p * q^(n-1)
def geometric_distribution(arr, n):
    p = arr[0]/arr[1]
    x = 1
    return negative_binomial_distribution(n, x, p)


if __name__ == '__main__':
    x1 = [int(i) for i in input().strip().split(' ')]
    x2 = int(input())
    value = "{:.3f}"
    cum = 0
    # print(value.format(geometric_distribution(x1, x2)))
    for i in range(1, 6, 1):
        cum += geometric_distribution(x1, i)
    print(value.format(cum))
