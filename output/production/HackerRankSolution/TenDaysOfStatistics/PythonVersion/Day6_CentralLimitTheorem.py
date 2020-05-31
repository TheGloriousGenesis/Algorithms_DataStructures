import math
from .tools.Tools import Tools

# Central Limit Distribution used for large sample (n > 30) stating that for
# large enough sample n, the distribution follows a normal distribution -
# assuming x is a sample of independant random variables from any distribution
# finite standard deviation

# distribution of sample set sums across a given data set will be close
# to the normal distribution where
# N(mu', sigma') --> where mu' = n * mu
#                --> sigma' = sqrt(n) * sigma


def central_limit_theorem(max_weight, number_of_boxes, mu, sigma):
    # use the probability that x < 9800 from the new estimated distribution
    p_x = Tools.normal_distribution()


if __name__ == '__main__':
    max_weight = int(input())
    number_of_boxes = int(input())
    mu = int(input())
    sigma = int(input())

    value = "{:.4f}"
    # print(value.format(geometric_distribution(x1, x2)))

