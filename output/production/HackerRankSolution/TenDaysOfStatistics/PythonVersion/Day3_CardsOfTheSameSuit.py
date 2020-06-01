from .tools.Tools import Tools

if __name__ == '__main__':
    value = "{}/{}"
    x = int(Tools.unordered_permutations(4, 1) * Tools.unordered_permutations(13, 2))
    y = int(Tools.unordered_permutations(52, 2))
    s = Tools()
    f = s.fraction_simplifier(x, y)
    print(value.format(f[0], f[1]))
