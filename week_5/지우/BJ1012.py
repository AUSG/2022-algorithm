import sys
sys.setrecursionlimit(100000)
input = sys.stdin.readline

def cabbage(x, y):
    a = [-1, 1, 1, -1]; b = [0, -1, 1, 1]

    if (0 <= x < n) and (0 <= y < m) and graph[x][y] == 1:
        graph[x][y] = 0
        # cabbage(x-1, y)
        # cabbage(x, y-1)
        # cabbage(x+1, y)
        # cabbage(x, y+1)
        for _ in range(4):
            x += a[_]
            y += b[_]
            cabbage(x, y)

t = int(input())
for _ in range(t):
    cnt = 0
    n, m, k = map(int, input().split())
    graph = [[0]*m for _ in range(n)]

    for _ in range(k):
        x, y = map(int, input().split())
        graph[x][y]=1

    for x in range(n):
        for y in range(m):
            if graph[x][y] == 1:
                cabbage(x, y)
                cnt += 1
    print(cnt)