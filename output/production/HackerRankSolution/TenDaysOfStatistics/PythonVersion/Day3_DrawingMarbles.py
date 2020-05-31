from .tools.Tools import Tools


def drawing_marbles():
    red = 3
    blue = 4
    total = red + blue
    r = 2
    # P(B|R)
    p_rb = (Tools.ordered_permutations(red, 1) * Tools.ordered_permutations(blue, 1)) / \
           Tools.ordered_permutations(total, r)
    p_r = 3/7
    return Tools.simple_bayes_theorem(p_rb, p_r)


if __name__ == '__main__':
    x = drawing_marbles()

    print(x)
