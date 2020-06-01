

# the probability that an event A will happen given that B has happened
# this is taking into account that A and B are not independant from each other

class ConditionalProbability:

    @staticmethod
    def bayes_theorem(p_a, p_ba, p_bac, p_ac):
        # complex version
        # P(A|B) = (P(B|A) * P(A))/(P(B|A) * P(A) + P(B|Ac) * P(Ac))
        return (p_ba * p_a)/((p_ba * p_a) + (p_bac * p_ac))


if __name__ == '__main__':
    p_ab_1 = ConditionalProbability.bayes_theorem(1/3, 1, 1, 2/3)

    print(p_ab_1)
    # P(RB|R)
