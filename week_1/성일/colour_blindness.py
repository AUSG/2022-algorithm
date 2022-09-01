import sys
import re
input = lambda : sys.stdin.readline().rstrip()
input_multiple_int = lambda : map(int,input().split())

T = int(input())

for _ in range(T):
    n = int(input())
    s1 = input()
    s2 = input()
    
    print("YES" if re.sub('B','G',s1) == re.sub('B','G',s2) else "NO")