import sys
input = lambda : sys.stdin.readline().rstrip()

T = int(input())
S = 'Timur'

for _ in range(T):
    n = int(input())
    s = input()
    if n != 5:    
        print('NO')
        continue
    if sorted(S) == sorted(s):
        print('YES')
    else:
        print('NO')