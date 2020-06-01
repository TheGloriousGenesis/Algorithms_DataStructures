import math


def normal_distribution(mean, std, x):
    constant = 1 / (std * math.sqrt(2 * math.pi))
    exponential = math.exp(-(pow(x - mean, 2)/ (2 * pow(std, 2))))
    return constant * exponential


def cumulative_probability(mean, std, x):
    # for normal distribution
    # distribution function of X evaluated at given x is cumulative for a
    # random variable X e.g F(x) = P(X<= x)
    # In this distribution P(X<= x) = P(X< x) !!!!
    component = (x - mean) / (std * math.sqrt(2))
    erf = math.erf(component)
    return 0.5 * (1 + erf)


if __name__ == '__main__':
    mu, sd = [float(i) for i in input().strip().split(' ')]
    c1 = int(input())
    c2 = int(input())
    dp = "{:.2f}"
    print(dp.format((1 - cumulative_probability(mu, sd, c1)) * 100))
    print(dp.format((1 - (cumulative_probability(mu, sd, c2))) * 100))
    print(dp.format((cumulative_probability(mu, sd, c2)) * 100))

    # mean, std = [float(i) for i in input().strip().split(' ')]
    # x1 = float(input())
    # x = [float(i) for i in input().strip().split(' ')]
    # value = "{:.3f}"
    # print(value.format(cumulative_probability(mean, std, x1)))
    # print(value.format(cumulative_probability(mean, std, x[1]) - cumulative_probability(mean, std, x[0])))
