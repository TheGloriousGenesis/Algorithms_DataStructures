def print_array(arg):
    print(array)


def insert(arg):
    array.insert(arg[0], arg[1])


def remove(arg):
    array.remove(arg[0])


def append(arg):
    array.append(arg[0])


def sort(arg):
    array.sort()


def pop(arg):
    array.pop()


def reverse(arg):
    array.reverse()


def command_to_action(command):
    arg = list(map(int, command[1:]))
    commandDict[command[0]](arg)


array = []
commandDict = {
    'print': print_array,
    'insert': insert,
    'remove': remove,
    'append': append,
    'sort': sort,
    'pop': pop,
    'reverse': reverse
}

if __name__ == '__main__':
    # N = int(input())
    # for i in range(N):
    #     command = list(i for i in input().split())
    #     command_to_action(command)
    x = int(input())
    y = int(input())
    z = int(input())
    n = int(input())
    print([[i, j, k] for i in range(x+1) for j in range(y+1) for k in range(z+1) if ((i+j+k) != n)])
