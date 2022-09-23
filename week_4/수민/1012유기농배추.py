import sys
sys.setrecursionlimit(10000)
from collections import deque

input = sys.stdin.readline


dx = [1,-1,0,0]
dy = [0,0,-1,1]

t = int(input())

def bfs(visited,ary):
    q = deque([[i,j]])
    while q:
        x,y = q.popleft()
        visited[x][y]=1
        for idx in range(4):
            X = x + dx[idx]
            Y = y + dy[idx]
            if 0<=X<n and 0<=Y<m and not visited[X][Y] and ary[X][Y]==1:
                if [X,Y] not in q:
                    q.append([X,Y])


for _ in range(t):
    m,n,k = map(int, input().split())
    ary = [[0 for i in range(m)] for j in range(n)]
    for __ in range(k):
        y,x = map(int,input().split())
        ary[x][y]=1

    visited = [[0 for i in range(m)] for j in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(m):
            if not visited[i][j] and ary[i][j]==1:
                bfs(visited,ary)
                cnt+=1
    print(cnt)