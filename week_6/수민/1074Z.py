import sys
input = sys.stdin.readline()

n,r,c = map(int,input.split())
result=0
#먼저 큰 부분으로 정복분할해서 단위 사이즈가 1이 될떼까지 진행
def divide_conquer(size,x,y):
    global result
    if x==r and y==c:
        print(result)
        exit(0)
    elif size==1:
        result+=1
        return
    #시간을 줄이기 위해 만약 해당 사이즈에 없으면 해당 사이즈 크기만큼 result에 추가해서 1단위까지 방문하지 않도록 함
    elif not (x <= r < x + size and y <= c < y + size):
        result += size * size
        return

    new_size = size//2
    #z 방향으로 정복분할
    divide_conquer(new_size,x,y)
    divide_conquer(new_size,x,y+new_size)
    divide_conquer(new_size,x+new_size,y)
    divide_conquer(new_size,x+new_size,y+new_size)

divide_conquer(2**n,0,0)