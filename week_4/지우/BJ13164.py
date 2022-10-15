n, k = map(int, input().split())
stu = list(map(int, input().split()))

diff = []
for i in range(n-1):
    diff.append(stu[i+1]-stu[i])
diff.sort(reverse=True)

print(sum(diff[k-1:]))