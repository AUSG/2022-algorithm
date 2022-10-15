import sys
input = sys.stdin.readline

def wordGame():
    n = int(input())
    wlist = [list(map(str, input().split())) for _ in range(3)] # 2차원 리스트 생성

    words = {}  # key: word, value: cnt 
    for _ in range(3):
        for i in range(n):
            v = wlist[_][i]
            if v not in words:
                words[v] = 1
            else:   words[v] += 1

    scores = [] # 세 명의 점수 출력
    for _ in range(3):
        score = 0
        for i in range(n):
            v = wlist[_][i]
            if words[v] == 1:  score += 3
            elif words[v] == 2: score += 1
            elif words[v] == 3: pass
        scores.append(score)
    return scores

t = int(input()); tt_score = []
for _ in range(t):
    tt_score.append(wordGame())

for x, y, z in tt_score:
    print(x, y, z)