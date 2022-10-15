import sys
from collections import deque
input = sys.stdin.readline

com = int(input()); n = int(input())
queue = deque([1]) # visited node
visited = [1]
graph = [[] for _ in range(com+1)]

cnt = 0
for _ in range(n):
    x, y = map(int, input().split())
    graph[x].append(y); graph[y].append(x)

while queue:
    q = queue.pop()
    for _ in graph[q]:
        if _ not in visited:
            queue.append(_)
            visited.append(_)
            cnt += 1
print(cnt)