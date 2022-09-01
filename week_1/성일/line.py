import sys
input = lambda : sys.stdin.readline().rstrip()

T = int(input())

for _ in range(T):
    n = int(input())
    s = input()

    ans = 0
    score = []

    for i in range(n):
        if s[i] == 'L':
            score.append(n - i - 1 - i)
            ans += i
        else:
            score.append(i - n + 1 + i)
            ans += n - 1 - i

    score.sort()

    for i in range(n):
        if score[i] > 0:
            ans += score[i]
        print(ans, end = " ")
    print()