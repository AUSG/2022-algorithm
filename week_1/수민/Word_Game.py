import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    dict = {}
    item = []
    for i in range(3):
        item.append(input().split())

    for i in range(3):
        for j in range(n):
            if item[i][j] in dict:
                dict[item[i][j]] += 1
            else:
                dict[item[i][j]] = 1
    result = []
    for i in range(3):
        sum = 0
        for j in range(n):
            val = dict[item[i][j]]
            if val == 1:
                sum += 3
            elif val == 2:
                sum += 1

        result.append(sum)

    print(" ".join(map(str, result)))