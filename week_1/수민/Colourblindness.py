import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    n = int(input())
    ary=[]
    for __ in range(2):
        ary.append(input())
    check=False
    for i in range(n):
        if ary[0][i] != ary[1][i]:
            if ary[0][i]=='R' or ary[1][i]=='R':
                check = True
    if check:
        print("NO")
    else:
        print("YES")