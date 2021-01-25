import math


class Tools:

    def fraction_simplifier(self, x1, x2):
        gcf = self.greatest_common_factor(x1, x2)
        x2 //= gcf
        x1 //= gcf
        return x1, x2

    def greatest_common_factor(self, y1, y2):
        """
        Uses Euclid Algorithm to find gcf.
        :param y1: int
            positive number
        :param y2: int
            positive number
        :return: int
            greatest common factor of y1 and y2
        """
        values = [y1, y2]
        values.sort()
        lowest_number = values[1] - values[0]
        if lowest_number != 0:
            return self.greatest_common_factor(lowest_number, values[0])
        return values[0]

    @staticmethod
    def simple_bayes_theorem(p_ab, p_a):
        """
        The probability of an event b happening given that a has happened; does NOT
         matter if b is dependant on the occurrence of a
        :param p_ab: float
            probability of a and b
        :param p_a: float
            probability of a
        :return: float
            probability of b given a -> P(B|A)
        """
        return p_ab / p_a

    @staticmethod
    def bayes_theorem(p_a, p_ba, p_bac, p_ac):
        """
        bayes theorem of conditionality probability:
        P(A|B) = (P(B|A) * P(A))/(P(B|A) * P(A) + P(B|Ac) * P(Ac))

        :param p_a: float
            possibility of a
        :param p_ba: float
            possibility of b given a
        :param p_bac: float
            possibility of a given b doesn't occur
        :param p_ac: float
            possibility of a not occurring
        :return: float
            possibility of a given b
        """
        return (p_ba * p_a)/((p_ba * p_a) + (p_bac * p_ac))

    @staticmethod
    def ordered_permutations(n, r):
        """
        An ordered arrangement of r objects from a set A of n objects where 0 < r <= n
        a way of organising n objects in r ways where the r ways DOES matter
        e.g in a group of n objects how many ways can x objects be rearranged?

        :param n: int
            total number of objects in set
        :param r: int
            number of permutations of sub set in n
        :return: int
            number of permutations of r possible given n objects
        """
        n_factorial = Tools.factorial(n)
        n_r_factorial = Tools.factorial(n - r)
        return n_factorial / n_r_factorial

    @staticmethod
    def unordered_permutations(n, r):
        """
        Also known as combinations

        An unordered arrangement of r objects from a set, A, of n objects where r <= n
        a way of organising n objects in r ways where the r ways DOES NOT matter (n r)
        e.g in a group of n objects how many ways can x objects be rearranged?

        :param n: int
            total number of objects in set
        :param r: int
            number of combinations of sub set in n
        :return: int
            number of combinations of r possible given n objects
        """
        n_factorial = Tools.factorial(n)
        n_r_factorial = Tools.factorial(n - r)
        r_factorial = Tools.factorial(r)
        return n_factorial / (n_r_factorial * r_factorial)

    @staticmethod
    def factorial(x):
        """
        Custom implementation of a factorial.
        recursive function
        Time complexity = O(x)
        :param x: int
            value needed to obtain factorial of
        :return: int
            factorial of x
        """
        n = x - 1
        if x == 0:
            return 1
        if n > 1:
            return Tools.factorial(n) * x
        else:
            return x

    @staticmethod
    def binomial(n, x, p):
        """
        Custom Implementation of the bionomial distribution. Gives distribution of possible
        number of successful outcomes given a number of trials in which each probability of success
        is the same
        :param n: int
            number of bernoulli trials
        :param x: int
            number of successes
        :param p: float
            probability of success

        where constant: p^x * (1-p)^(n-x)

        :return: int
            binomial random variable
        """
        constant = Tools.unordered_permutations(n, x)
        return constant * pow(p, x) * pow((1 - p), (n - x))

    @staticmethod
    def negative_binomial_distribution(n, x, p):
        """
        probability of having (x -1) successes after (n -1) trials and having
        x successes after n trials. (n - 1, x -1) * p^x * q^(n-x)
        :param n:
        :param x:
        :param p:
        :return:
        """
        # constant = tools.unordered_permutations(n - 1, x - 1)
        constant = math.factorial(n-1) / (math.factorial((n-1) - (x-1)) * math.factorial(x-1))
        return constant * pow(p, x) * pow((1 - p), (n - x))

    @staticmethod
    def normal_distribution(mean, std, x):
        """
        Implementation of Normal Distribution
        """
        constant = 1 / (std * math.sqrt(2 * math.pi))
        exponential = math.exp(-(pow(x - mean, 2) / (2 * pow(std, 2))))
        return constant * exponential


if __name__ == '__main__':
    top = int(input())
    bottom = int(input())
    s = Tools()
    f = s.fraction_simplifier(top, bottom)
    value = "{}/{}"
    print(value.format(f[0], f[1]))
