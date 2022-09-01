import sys
from collections import defaultdict
input = lambda : sys.stdin.readline().rstrip()

T = int(input())

for _ in range(T):
    n = int(input())
    S = []
    for i in range(3):
        S.append(input().split())
    
    d = defaultdict(int)

    for strings in S:
        for string in strings:
            d[string] += 1
            
    res = []

    for strings in S:
        r = 0
        for string in strings:
            if d[string] == 1:
                r += 3
            elif d[string] == 2:
                r += 1
            else:
                continue
        res.append(r)
    print(*res)