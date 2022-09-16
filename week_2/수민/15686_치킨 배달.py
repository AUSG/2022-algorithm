import sys

input = sys.stdin.readline

n,m = map(int,input().split())
ary = [list(map(int,input().split())) for _ in range(n)]
chick=[]
result=[5001]
house = []
for i in range(n):
    for j in range(n):
        if ary[i][j]==2:
            chick.append([i,j])
        elif ary[i][j]==1:
            house.append([i,j])
def dfs(idx,cnt,loc):
    if cnt == m:
        calc(loc)
        return
    for i in range(idx,len(chick)):
        if not loc[i]:
            loc[i]=1
            dfs(i,cnt+1,loc)
            loc[i]=0
def calc(loc):
    sum = 0
    resMin = min(result)
    for i,j in house:
        value = 101
        for k in range(len(chick)):
            if loc[k]:
                x,y=chick[k]
                value = min(value,abs(i-x)+abs(j-y))
        sum+=value
        if sum > resMin:
            return
    result.append(sum)

dfs(0,0,[0 for _ in range(len(chick))])
print(min(result))