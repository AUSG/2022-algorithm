#이건 정답이었는데 갑자기 오답처리가..ㅠ
import sys

input = sys.stdin.readline
from collections import deque

t = int(input())
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


def bfs(i, j, visited, n, m, ary):
    q = deque([[i, j]])
    cnt = 0
    temp = []
    while q:
        x, y = q.popleft()
        temp.append([x, y])
        visited[x][y] = 1
        cnt += 1
        for idx in range(4):
            X = dx[idx] + x
            Y = dy[idx] + y
            if 0 <= X < n and 0 <= Y < m and not visited[X][Y]:
                if ary[X][Y] == "*" and [X, Y] not in q:
                    q.append([X, Y])
    if cnt != 3:
        return False
    # 일직선으로 된거 거르는 부분
    if temp[0][0] == temp[1][0] and temp[1][0] == temp[2][0]:
        return False
    elif temp[0][1] == temp[1][1] and temp[1][1] == temp[2][1]:
        return False
    # 세개로 ㄴ ㄱ 테트리스가 완성된 후 대각선에 *존재하는지 확인하는 부분
    DX = [-1, -1, 1, 1]
    DY = [-1, 1, -1, 1]
    for item in temp:
        x, y = item
        for idx in range(4):
            X = DX[idx] + x
            Y = DY[idx] + y
            if 0 <= X < n and 0 <= Y < m and [X, Y] not in temp:
                if ary[X][Y] == "*":
                    return False
    return True


for _ in range(t):
    n, m = map(int, input().split())
    ary = []
    for i in range(n):
        ary.append(list(input()))
    visited = [[0 for _ in range(m)] for __ in range(n)]
    check = False
    for i in range(n):
        if check:
            break
        for j in range(m):
            if ary[i][j] == '*' and not visited[i][j]:
                if not bfs(i, j, visited, n, m, ary):
                    check = True
                    break

    if check:
        print("NO")
    else:
        print("YES")