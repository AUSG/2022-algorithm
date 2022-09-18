import sys
input = sys.stdin.readline

def colorBlindness():
    n = int(input()); grid = []; color = ''

    for _ in range(2):
        color = input()
        color = color.replace('G', 'B')
        grid.append(color.strip())
    
    if grid[0] == grid[1]:  return 'YES'
    else: return 'NO'

t = int(input()); ans = []
for _ in range(t):
    ans.append(colorBlindness())
for _ in ans:
    print(_)