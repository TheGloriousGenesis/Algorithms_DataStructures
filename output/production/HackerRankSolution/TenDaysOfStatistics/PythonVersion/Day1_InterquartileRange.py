def start():
    global n
    n = int(input())
    x = [int(i) for i in input().strip().split(' ')]
    f = [int(i) for i in input().strip().split(' ')]
    return x, f


def interquartile_range(x, f):
    s = []
    for i in range(n):
        freq = f[i]
        for j in range(freq):
            s.append(x[i])
    s.sort()
    q1_arr = s[:len(s)//2] if len(s) % 2 == 0 else s[:(len(s) - 1)//2]
    q3_arr = s[len(s)//2:] if len(s) % 2 == 0 else s[(len(s) + 1)//2:]
    median_q1 = find_median(q1_arr)
    median_q3 = find_median(q3_arr)
    return median_q3 - median_q1


def find_median(arr):
    length = len(arr)
    if length % 2 == 0:
        return (arr[length//2] + arr[length//2 - 1])/2
    else:
        return arr[length//2]


if __name__ == '__main__':
    x, f = start()

    value = "{:.1f}"
    print(value.format(interquartile_range(x, f)))
