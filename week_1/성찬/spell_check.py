
from itertools import permutations
 
nameSet = set(["".join(i) for i in permutations("Timur")])
 
T = int(input())
 
 
def correct(length, name):
    if length != 5:
        return False
 
    return name in nameSet
 
 
for i in range(T):
    if correct(int(input()), input()):
        print("YES")
        continue
 
    print("NO")
