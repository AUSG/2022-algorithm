import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    name = input()
    check = False
    lists = ['T', 'r', 'u', 'm', 'i']
    for i in range(n):
        if name[i] not in lists:
            check = True
        else:
            lists.remove(name[i])

    if check or n < 5:
        print("NO")
    else:
        print("YES")