from Tools.Simplifier import Simplifier


class Cep:

    @staticmethod
    def compound_prob():
        # for visualisation reasons
        x = [1, 1, 1, 1, 0, 0, 0]
        y = [1, 1, 1, 1, 1, 0, 0, 0, 0]
        z = [1, 1, 1, 1, 0, 0, 0, 0]

        x_red = 4
        y_red = 5
        z_red = 4

        x_black = 3
        y_black = 4
        z_black = 4

        bottom_frac = len(x)*len(y)*len(z)

        total = (x_red * y_red * z_black) + \
                (z_red * x_red * y_black) + \
                (y_red * z_red * x_black)
        return total, bottom_frac


if __name__ == '__main__':
    x, y = Cep.compound_prob()

    value = "{}/{}"

    s = Simplifier()
    s_value, s_value1 = s.fraction_simplifier(x, y)

    print(value.format(s_value, s_value1))
